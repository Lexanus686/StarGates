package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO FOR TASK
//TODO MY BL = ENTITIES + USe CASES(что моджет хотеть, случай использования)
//TODO INTERACTOR ~ MANAGER
//TODO FACADE (ADD)
//TODO FACADE.getAllSMTHWIthProgress(args, Listener<...>): Future<Result> - в-строенный java
//TODO Background operation<Planet or smth> - инкапсулирует в себе длинную операцию. У операции результат и прогресс (long time)
//TODO PR - progress reporter - принимает PR и плюется result. И говорим, что хочу выполнить это действие (new Task)
//TODO у PR - BackgroundOper. where was created
//TODO Listener'ом мы подписываемся на Observable_tmp'a,

//TODO Task - incapsulation of thread.

//TODO PATTERNS LISTENER & OBSERVABLE

//TODO BACKGROUNDOPERATION (в нем Observable_tmp) и some PROGRESS - BL

class DBHandler {
    private static Connection instance = null;
    private static final String CON_STR_MAIN_DB = "jdbc:sqlite:C:/Users/User/.IntelliJIdea2018.2/StarGates/src/main/java/DataBase/MainDB.s3db";

    static synchronized Connection getConnection() throws SQLException {
        if (instance == null)
            instance = DriverManager.getConnection(CON_STR_MAIN_DB);
        return instance;
    }

}