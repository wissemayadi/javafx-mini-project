/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.util.Properties;

/**
 *
 * @author naderayadi
 */
public class Server {

  public void Download() throws JSchException{
      try {
          String user="user";
          String pass="password";
          Properties config=new Properties();
          config.put("StrictHostKeyChecking","no");
              String host="127.0.0.1";
          JSch jsch = new JSch();
          Session session = jsch.getSession(user,host);
          session.setPassword(pass);
          session.setConfig(config);
          session.connect();
         var type="sftp";
          ChannelSftp channelSftp = (ChannelSftp)session.openChannel(type);
          channelSftp.connect();
//          channelSftp.rename("/Users/naderayadi/Public/sfp/newfile.txt","/Users/naderayadi/Public/sfp/newfile2.txt");
//          String src="/Users/naderayadi/NetBeansProjects/projectLogin/src/newfile.txt";
            String src="/Users/naderayadi/Cv1.pdf";
           String dst="/Users/naderayadi/NetBeansProjects/projectLogin/src/Cv1.pdf";
//          String dst="/Users/naderayadi/Public/sfp/newfile.txt";
          channelSftp.put(src,dst);
          System.out.println("session connected:"+session.isConnected());
          
          channelSftp.disconnect();
          session.disconnect();
      } catch (Exception e) {
          e.printStackTrace();
      }
 
  }
public static void main(String []args) throws JSchException{
//    Server sv =new Server();
//    System.out.println(sv);
}
}
