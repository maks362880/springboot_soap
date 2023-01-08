# Тестовое задание: backend SOAP + RESTfull

### Дано:

1. Клиент (идентификатор, имя, индивидуальная скидка 1, индивидуальная скидка 2).
2. Товар (Идентификатор, наименование, Цена, описание, оценки покупателей). 
3. Факт продажи (идентификатор клиента, дата продажи, номер чека, список позиций). Позиция - идентификатор товара, кол-во, исходная цена (для заданного кол-ва товаров), конечная цена, конечная скидка (%).

Раз в час случайным образом выбирается товар, на который следующий час будет действовать скидка. Скидка выбирается случайным образом от 5% до 10% и фиксируется в БД.
Клиент может выбрать несколько товаров (одну или более единиц каждого товара), запросить итоговую стоимость и зафиксировать факт покупки (с точки зрения сервисов - факт продажи).
При заказе 5 и более единиц товара применяется индивидуальная скидка 2 (если не равна 0). При заказе меньшего числа единиц или отсутствии индивидуальной скидки 2 применяется индивидуальная скидка 1.
Индивидуальная скидка суммируется со скидкой на товар, но общая скидка не должна превышать 18%.
Номер чека уникален в пределах суток, состоит из пяти цифр с лидирующими нулями, каждый день нумерация начинается с 00100 и растет последовательно (+1 для каждого чека).
Клиент может поставить оценку любому товару, который он приобретал (один товар - одна оценка, независимо от кол-ва приобретенных товаров).

### Задание:
Разработать backend с soap сервисом и дублирующим restFull, которые реализуют следующие методы:
1. список клиентов (все атрибуты).
2. изменение индивидуальных скидок клиента (входные параметры: идентификатор, скидка 1, скидка 2).
3. список товаров (идентификатор, наименование, цена).
4. получение дополнительной информации о товаре 
   вх. параметры:
- идентификатор товара;
- идентификатор клиента
  вых. параметры: 
   - описание;
   - средняя оценка (с точностью до 1 десятичного знака);
   - распределение оценок (от 1 до 5, парами "оценка - количество");
   - текущая оценка товара клиентом.
5. Запрос итоговой стоимости 
	вх. параметры:
	- идентификатор клиента
	- парами: идентификатор товара,  количество.
	вых. параметры:
	- итоговая стоимость с учетом скидок (в копейках).
6. Регистрация продажи
	вх. параметры:
	- парами: идентификатор товара, количество;
	- итоговая стоимость с учетом скидок (в копейках).
	вых. параметры:
	- номер чека.
	Ошибка в том случае, если переданная итоговая стоимость не соответствует рассчитанной на момент регистрации продажи.
7. Оценка товара
	вх. параметры:
	- идентификатор клиента;
	- идентификатор товара;
	- оценка (1-5 или null для отзыва оценки).
8. Получение статистики
	вх. параметры:
	- идентификатор клиента;
	- идентификатор товара;
	Может быть передан только один.
	вых. параметры:
	- кол-во чеков;
	- общая стоимость (для клиента - чеков, для товаров - соотв. позиций) по исходной цене;
	- сумма скидок (для клиента - по всем позициям чеков, для товаров - соотв. позиций).


### Требования к реализации:
	- генерация статистики и скидок производится фоновым процессом по таймеру;
	- Скрипты для бд выполнять через liquibase (оформить как отдельный gradle проект).
### Технологии:
 springBoot, JPA(Hibernate), restfull, apache cxf, PostgreSQL, java 8, gradle.
Результат:
 исходный проект + jmeter проект с одним тест-кейсом любого restFull метода.

### Описание реализации:

Структура таблиц БД реализовна в пакете entity c помощью JAVA POJO классов, для совместимости с JPA реализован импорт библиотеки javax.persistence.*

Каждой entity соответсвует своя таблица в БД.

Для работы с Spring Data использована прослойка в виде пакета services, который в свою очередь обращается в пакет dao где реализована связь класса с БД через наследуемый класс JpaRepository.

Основная REST логика расположенна в пакете rest, для каждой сущности создан отдельный REST контроллер.

В случае отсутсвия в БД запрашиваемых данных реализован JSON ответ с телом сообщения вида "There are no XXXX with id = YYY in Database" реализованного с помощю обработки исключений в пакете  exeption_handling для каждой сущности отделно.

SOAP логика проинициализированна в пакете config и реализованна в пакете soap через соответсвующие интерфейсы для каждой сущности отделно.

Реализованные в soap пакете классы так же как и в REST обращаются в пакт dao где присутсвует связь класса с БД через наследуемый класс JpaRepository.

Ежечасный выбор скидки на товар реализован в пакете services с помощю класса DiscountScheduler.
Основная логика работы завязана на таймер с аннотацией @Scheduled.
Каждый час с помощю метода Math.random() генерируется случайное число от 5 до 10 и записывается в БД.
Критерий поиска товара, в который будет записана случайная скидка следующий:
1) вычисляется общее количество товаров в базе данных при помощи запроса goodsService.getGoodsCount()
2) на основе полученного числа генерируется с помощю метода Math.random() случайное значение от 0 до общего количества товаров вычисленного ранее.
3) в базу данных записывается скидка вычислення в п.1 и записывается в таблицу с товаром с позицией вычисленной в п.2

