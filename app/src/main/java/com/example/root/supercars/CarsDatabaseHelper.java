package com.example.root.supercars;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CarsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "sCars";
    private static final int DB_VERSION = 1;


    CarsDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE CARS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "ANIMAL_IMAGE INTEGER, " +  "MODEL, " + "CAR_IMAGE INTEGER, " + "ENGINE, " + "WEIGHT, " + "BHP, " + "ACCEL, " +"SPEED, " +"PRICE, " + "DESCRIPTION TEXT);");
        db.execSQL("CREATE TABLE NEWCARSCTGRS(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "LOGO, " + "BRAND);");
        db.execSQL("CREATE TABLE NEWCARS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "BRAND, " + "MODEL, "+ "CAR_IMAGE INTEGER, " + "ENGINE, " + "WEIGHT, " + "BHP, " + "ACCEL, " +"SPEED, " +"PRICE, " + "DESCRIPTION TEXT);");
        insertCars(db, "Самая быстрая", R.drawable.cheetah, "Devel Sixteen", R.drawable.develsixteen, "12.3-liter V16", "2300 кг", "5000 л.с.", "1.8 сек.", "563 км/ч", "~1 000 000 $ (Слухи)", "В ноябре 2013 года на автошоу в Дубае дебютировал прототип гиперкара Devel Sixteen. Его представила никому не известная компания Defining Extreme Vehicles Car Industry из ОАЭ. Заявление о том, что машина оснащена мотором мощностью 5000 л.с., большинство восприняло скептически. Но теперь американская фирма Steve Morris Engines (SME) представила доказательства: она действительно разработала для арабов двигатель V16 объёмом 12,3 л, который выдал на стенде 4515 л.с., 4771 Н•м. И это предел не агрегата, а измерительной аппаратуры. ");
        insertCars(db, "Самая прочная", R.drawable.crocodile, "Paramount Marauder", R.drawable.marauder,"6.9- liter 6 цилиндровый дизельный MAN DO0836", "12 000 кг", "224 л.с.", " - ", "120 км/ч", "480 000 $", "Самый прочный на сегодняшний день автомобиль был собран компанией Paramount (ПАР). Это известный мировой производитель самых технологичных и защищенных бронированных машин.\n" +
                "\n" +
                "Сначала автомобиль создавали для сопровождения транспортных колонн и перевозки пехотных отрядов. Сейчас же его может купить каждый, поскольку в Африке большинство стран живут с криминализированным обществом, бронеавтомобиль используется людьми, которых хотят убить или подорвать на каждом шагу.\n" +
                "\n" +
                "Серийное производство находится в Иордании, а разработка – в ЮАР. Это сделано для того, чтобы снизить стоимость автомобиля и техническое обслуживание. Например, в Paramount Marauder использовали дизельный двигатель и мосты производства компании фирмы MAN мощностью 224 \"лошадок\" и 801 Нм.\n" +
                "\n" +
                "Marauder является бронированным автомобилем, который еще и осуществляет перевозки личного состава. Ему не страшны ни попадания ракет, ни взрывы мин. Немало испытаний предстояло выдержать этому броневику, и со всеми он с достоинством справлялся. Он без каких-либо трудностей давил машины и пробивал тараном кирпичные стены." );
        insertCars(db, "Самая дорогая", R.drawable.peacock,"Maybach Exelero", R.drawable.exelero,"5.9 - liter v12 Twin Turbo", "2660 кг", "700 л.с.", "4.4 сек.", "351 км/ч", "8 000 000 $", "Maybach Exelero, несмотря на гламурное такое имечко, не был создан для простоя на стендах под присмотром специально обученных людей с тряпочками. Под этим дьявольским кузовом скрыто вполне себе дьявольское железо, заточенное под одну конкретную задачу: испытать очень крутые... покрышки. \n" +
                "\n" +
                "В Mercedes-Maybach, как вы знаете, задумали возродить Exelero. Ну, не то чтобы в точности повторить опыт, но черты сумасшедшего купе определенно просматриваются в новом роскошном концепте немцев. Самое время вспомнить пусть и дальнего, но родственника.В 2003 году фирма Fulda — известный немецкий производитель шин, с 1962-го входит в состав концерна Goodyear — обратилась в \"Мерседес\" с просьбой сделать достаточно большую, тяжелую и сверхбыструю машину для испытаний новейших, самых широких на то время шин.\n" +
                "\n" +
                "Это был не первый такой случай — в 1938-м для тех же целей Fulda был построен Maybach SW38, который смог больше 200 километров в час (78 лет назад!).\n" +
                "\n" +
                "Для встречи с современными покрышками требовалось что-то намного более серьезное\nВ Mercedes-Benz могли просто предложить S 55 AMG или SLR McLaren с несколькими мешками картошки на борту. Но вместо этого решили взбодрить сверхроскошную линейку Maybach и, вдохновившись супермашинами 1930-х, построили его: в 2005 году в Берлине был показан фантастический 2,6-тонный Exelero (который, кстати, остался в одном-единственном экземпляре).Несмотря на огромный кузов, Exelero был и остается двухместным и двухдверным (сегодня этот параметр приходится уточнять) купе. Вершина эгоизма.\n" +
                "\n" +
                "Машина была построена на базе седана 57S, но отличалась смещенным назад салоном — в пропорциях довоенных спидстеров. А под гигантским капотом расположился уникальный V12 — двигатель \"обычного\" Maybach с увеличенным до 5,9 литра объемом и двумя большими турбинами, на 700 сил и 1000 Нм крутящего момента. Добавьте сюда 23-дюймовые колеса и попробуйте усомниться в заявленных 350 км/ч максимальной скорости. На самом деле Exelero смог даже больше. 1 мая 2005 года более чем шестиметровая двухдверка в компании опытного гонщика Клауса Людвига прибыла на итальянский трек Нардо — кольцо для очень быстрых испытаний. И показала там среднюю скорость свыше 351 км/ч. Работа была сделана. \n" +
                "\n" +
                "Выполнив задание, фантастический Maybach жил веселой жизнью. Например, в 2011-м известный рэп-исполнитесь Birdman заявил, что купил Exelero за $8 млн и собирается перекрасить его в ярко-красный. Однако владельцы заверили, что никаких денег не брали, и продолжили предлагать автомобиль на продажу. Насколько нам известно, он все еще черный. Вы можете сказать, что Exelero уродливый и даже бесполезный. Можете назвать его точкой, с которой весь Maybach свернул не туда. Но, позвольте, это — мощная работа инженеров, что заслуживает нашего уважения. И вообще — думаем, именно на Exelero мог бы ездить Сатана." );
        insertCars(db, "Самая большая", R.drawable.elephant,"БелАЗ-75710", R.drawable.belaz_800x696, " 2 x 65-liter v16 MTU Detroit Diesel", "360 000 кг", "2 x 2300 л.с", " - ", "64 км/ч", "2 000 000 $ - 4 000 000 $", "В январе 2014 года самосвал БелАЗ 75710 еще выше поднял планку производительности для карьерных самосвалов, переместив на специальном полигоне груз весом в 503,5 тонны. Это на 11% больше предусмотренных в паспорте 450 тонн и почти на 100 тонн превышает достижение предыдущего рекордсмена 363-х тонного Liebherr T 282B. Этот автомобиль продолжил традицию белорусских автомобилестроителей раз в несколько лет представлять очередной самосвал с увеличенной грузоподъемностью. В 2005 году с конвейера завода вышел автомобиль грузоподъемностью 320 тонн, через два года БелАЗ представил модель способную перевозить 360 тонн груза. И вот в 2013 году белорусские автомобилестроители выпустили самые большой БелАЗ в мире — автомобиль способный перевозить свыше 500 тонн груза. Документальное видео и фото БелАЗ 75710 наглядно демонстрирует возможности этого сверхбольшегрузного автомобиля." );
        insertCars(db, "Самая медленная", R.drawable.snail,"Peel P50", R.drawable.peelp50, "0.5 - liter 49cc Four Stroke CVT(Petrol)/ DC Brushless CVT(Electric)", "59 кг",  "3.35 л.с.", " -  ", "45-50 км/ч", "~15 000 $", "В 1963-1964 годах британская компания Peel Engineering производила микролитражный автомобиль под названием Peel P50, который до сих пор удерживает рекорд самого маленького серийного авто в мире. Трехколесная машинка имеет невообразимые габариты: 1,34 метра в длину, 0,99 - в ширину и 1,2 - в высоту, и вмещает лишь одного взрослого человека, правда, в ее кабине смог поместиться даже ведущий Top Gear Джереми Кларксон со своим немалым ростом.\n" +
                "\n" +
                "В техническом плане характеристики Peel P50 соответствовали его неамбициозным размерам. Автомобиль оснащался 49-кубовым мотоциклетным двухтактным мотором DKW мощностью 4,2 л.с. и агрегатировался с трехступенчатой коробкой без задней передачи. Максимальная скорость производителем была заявлена на отметке в 61 км/ч, расход топлива составлял около 3 литров на 100 км.\n" +
                "\n" +
                "Несмотря на всю несерьезность проекта по всем параметрам, существовала даже своего рода \"спортивная\" версия этой \"малютки\" - Peel Trident, которая по сути пришла на смену модели P50 и выпускалась в 1964-1966 годах в двухместном кузове со стеклянным колпаком кабины из плексигласа.\n" +
                "\n" +
                "В 2010 году Peel P50 был возрожден в электрической версии, а недавно представители Peel Engineering сообщили о намерении выпустить и бензиновую версию \"трехколески\" в обоих вариантах кузова - P50 и Trident. По некоторым данным, микромобиль будет оборудован 50-кубовым двухтактным двигателем, который развивает 3,35 л.с.\n" +
                "\n" +
                "Впрочем, цена возрожденного Peel вовсе не такая смешная, как его внешность, размеры и технические характеристики - стоимость \"римейка\" начинается от отметки в 10 772 долларов. Однако, даже тем, кто пожелает купить этот шедевр на колесах, следует поторопиться с предзаказом, поскольку производитель планирует выпустить автомобиль очень ограниченной серией в общем количестве 50 штук.");

        insertNewCarsCtgrs(db, R.drawable.alfaromeo, "Alfa Romeo");
        insertNewCarsCtgrs(db, R.drawable.astonmartin, "Aston Martin");
        insertNewCarsCtgrs(db, R.drawable.audi, "Audi");
        insertNewCarsCtgrs(db, R.drawable.bentley, "Bentley");
        insertNewCarsCtgrs(db, R.drawable.bmw, "BMW");
        insertNewCarsCtgrs(db, R.drawable.bugatti, "Bugatti");
        insertNewCarsCtgrs(db, R.drawable.cadillac, "Cadillac");
        insertNewCarsCtgrs(db, R.drawable.chevrolet, "Chevrolet");
        insertNewCarsCtgrs(db, R.drawable.dodge, "Dodge");
        insertNewCarsCtgrs(db, R.drawable.ferrari, "Ferrari");
        insertNewCarsCtgrs(db, R.drawable.ford, "Ford");
        insertNewCarsCtgrs(db, R.drawable.honda, "Honda");
        insertNewCarsCtgrs(db, R.drawable.jaguar, "Jaguar");
        insertNewCarsCtgrs(db, R.drawable.koenigsegg, "Koenigsegg");
        insertNewCarsCtgrs(db, R.drawable.lamborghini, "Lamborgini");
        insertNewCarsCtgrs(db, R.drawable.maserati, "Maserati");
        insertNewCarsCtgrs(db, R.drawable.maybach, "Maybach");
        insertNewCarsCtgrs(db, R.drawable.mazda, "Mazda");
        insertNewCarsCtgrs(db, R.drawable.mclaren, "McLaren");
        insertNewCarsCtgrs(db, R.drawable.mercedes, "Mercedes - Benz");
    }

    private static void insertCars(SQLiteDatabase db, String name, int animalId, String model, int carId, String engine, String weight, String bhp, String accel, String speed, String price, String description){
        ContentValues carsValues = new ContentValues();
        carsValues.put("NAME", name);
        carsValues.put("ANIMAL_IMAGE", animalId);
        carsValues.put("MODEL", model);
        carsValues.put("CAR_IMAGE", carId);
        carsValues.put("ENGINE", engine);
        carsValues.put("WEIGHT", weight);
        carsValues.put("BHP", bhp);
        carsValues.put("ACCEL", accel);
        carsValues.put("SPEED", speed);
        carsValues.put("PRICE", price);
        carsValues.put("DESCRIPTION", description);
        db.insert("CARS", null, carsValues);
    }
    private static void insertNewCarsCtgrs(SQLiteDatabase db, int logo, String brand){
        ContentValues NewCarsCtgrs = new ContentValues();
        NewCarsCtgrs.put("LOGO", logo);
        NewCarsCtgrs.put("BRAND", brand);
        db.insert("NEWCARSCTGRS", null, NewCarsCtgrs);
    }



    private static void insertNewCars(SQLiteDatabase db, String brand, String model, int carimage, String engine, String weight, String bhp, String accel, String speed, String price, String descr){
        ContentValues newCarsValues = new ContentValues();
        newCarsValues.put("BRAND", brand);
        newCarsValues.put("MODEL", model);
        newCarsValues.put("CAR_IMAGE", carimage);
        newCarsValues.put("ENGINE", engine);
        newCarsValues.put("WEIGHT", weight);
        newCarsValues.put("BHP", bhp);
        newCarsValues.put("ACCEL", accel);
        newCarsValues.put("SPEED", speed);
        newCarsValues.put("PRICE", price);
        newCarsValues.put("DESCRIPTION", descr);
        db.insert("NEWCARS", null, newCarsValues);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
