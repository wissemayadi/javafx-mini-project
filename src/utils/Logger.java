/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author naderayadi
 */

    import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author colby
 */
public class Logger {
    
    public static void loginSuccess(String login) throws IOException {
        String output = createLogString(login, "SUCCESS");
        writeStringToLog(output);
    }
    
    public static void loginFailure(String username) throws IOException {
        String output = createLogString(username, "FAILURE");
        writeStringToLog(output);
    }
    
    private static void writeStringToLog(String output) throws IOException {
        File file = new File("logging.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
        writer.write(output);
        writer.newLine();
        writer.close();
    }
    
    private static String createLogString(String login, String status) {
        return Instant.now().toString() + " : login = " + login + " : " + status;
    }
}

