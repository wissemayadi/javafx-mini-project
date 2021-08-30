///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package utils;
//
//
//package net.xfok.ftp;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.Properties;
//import java.util.Vector;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
///**
//* @author YangHua
// * Please indicate the source:http://www.xfok.net/2009/10/124485.html
//*/
//public class MySftp {
//
///**
// * Connect the SFTP server
//* @param  Host host
//* @param  Port port
//* @param  Username username
//* @param  Password password
//* @return
//*/
//public ChannelSftp connect(String host, int port, String username,
//String password) {
//ChannelSftp sftp = null;
//try {
//JSch jsch = new JSch();
//jsch.getSession(username, host, port);
//Session sshSession = jsch.getSession(username, host, port);
//System.out.println("Session created.");
//sshSession.setPassword(password);
//Properties sshConfig = new Properties();
//sshConfig.put("StrictHostKeyChecking", "no");
//sshSession.setConfig(sshConfig);
//sshSession.connect();
//System.out.println("Session connected.");
//System.out.println("Opening Channel.");
//Channel channel = sshSession.openChannel("sftp");
//channel.connect();
//sftp = (ChannelSftp) channel;
//System.out.println("Connected to " + host + ".");
//} catch (Exception e) {
//
//}
//return sftp;
//}
//
///**
// * upload files 
//* @param  Directory upload directory
//* @param  UPLOADFILE to upload files
//* @param sftp
//*/
//public void upload(String directory, String uploadFile, ChannelSftp sftp) {
//try {
//sftp.cd(directory);
//File file=new File(uploadFile);
//sftp.put(new FileInputStream(file), file.getName());
//} catch (Exception e) {
//e.printStackTrace();
//}
//}
//
///**
// * download file 
//* @param  Directory Download Directory
//* @param  Downloadfile Download
//* @param  Savefile exists local path
//* @param sftp
//*/
//public void download(String directory, String downloadFile,String saveFile, ChannelSftp sftp) {
//try {
//sftp.cd(directory);
//File file=new File(saveFile);
//sftp.get(downloadFile, new FileOutputStream(file));
//} catch (Exception e) {
//e.printStackTrace();
//}
//}
//
///**
// * Delete Files 
//* @param  Directory wants to delete the file where the file is located
//* @param  Deletefile wants to delete files
//* @param sftp
//*/
//public void delete(String directory, String deleteFile, ChannelSftp sftp) {
//try {
//sftp.cd(directory);
//sftp.rm(deleteFile);
//} catch (Exception e) {
//e.printStackTrace();
//}
//}
//
///**
// * List the files in the directory
//* @param  Directory to list the directory to list
//* @param sftp
//* @return
//* @throws SftpException
//*/
//public Vector listFiles(String directory, ChannelSftp sftp) throws SftpException{
//return sftp.ls(directory);
//}
//
//public static void main(String[] args) {
//MySftp sf = new MySftp(); 
//String host = "127.0.0.1";
//int port = 22;
//String username = "wissem ayadi";
//String password = "password";
//String directory = "/Users/naderayadi/";
//String uploadFile = "/Users/naderayadi/NetBeansProjects/projectLogin/src/newfile.txt";
//String downloadFile = "newfile.txt";
//String saveFile = "/Users/naderayadi/NetBeansProjects/projectLogin/src/newfile.txt";
//String deleteFile = "/Users/naderayadi/NetBeansProjects/projectLogin/src/newfile.txt";
//ChannelSftp sftp=sf.connect(host, port, username, password);
////sf.upload(directory, uploadFile, sftp);
////sf.download(directory, downloadFile, saveFile, sftp);
//sf.delete(directory, deleteFile, sftp);
//    System.out.println("file deleted");
//try{
//sftp.cd(directory);
////sftp.mkdir("ss");
//System.out.println("finished");
//
//}catch(Exception e){
//e.printStackTrace();
//} 
//} 
//}
