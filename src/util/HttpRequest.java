/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author William
 */
public class HttpRequest {
    private String USER_AGENT = "Mozilla/5.0";
  private static  HttpURLConnection con;
   
  //Http GET request
    public String sendGet(String url){
        try {
        URL Url = new URL(url);
         con = (HttpURLConnection) Url.openConnection();
        
        //Metodo get é padrão
        con.setRequestMethod("GET");
        
        //adicionar request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = con.getResponseCode();
            System.out.println("/n Sendind 'GET' Request to URL " + url);
            System.out.println("/n ResponseCode" + responseCode);
            
            BufferedReader in = new BufferedReader(
                            new InputStreamReader (con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while( (inputLine = in.readLine()) != null ){
            response.append(inputLine);
        }
    
        in.close();
        con.disconnect();
        //retorna resultado
        return response.toString();
        }catch(MalformedURLException ex){
            System.out.println("Erro de Url mal formada no GET" + ex.toString());
            return null;
        }
        catch(IOException ex){
            System.out.println("Erro de Leitura e Escrita I/O no GET" + ex.toString());
            return null;
            
        }
        
    }
        
        // HTTP POST request
	public void sendPost(String url, String urlParameters) {
 
            try{
		// url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		 con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/json");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                
		// urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
           
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
      System.out.println("Deu certo");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                con.disconnect();
		//print result
		System.out.println(response.toString());
 
            }
            catch(MalformedURLException ex){
            System.out.println("Erro de Url mal formada no POST" + ex.toString());
          
        }
        catch(IOException ex){
            System.out.println("Erro de Leitura e Escrita I/O no POST" + ex.toString());
         
            
        }
        
        }
            
            // HTTP POST request
	public void sendPut(String url, String urlParameters) {
 
            try{
		// url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		 con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("PUT");
                con.setRequestProperty("Content-Type","application/json");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                
		// urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
           
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'PUT' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
      System.out.println("Deu certo");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                con.disconnect();
		//print result
		System.out.println(response.toString());
 
            }
            catch(MalformedURLException ex){
            System.out.println("Erro de Url mal formada no PUT" + ex.toString());
          
        }
        catch(IOException ex){
            System.out.println("Erro de Leitura e Escrita I/O no PUT" + ex.toString());
         
            
        }          
	}
        
        
        
        public String sendDelete(String url){
        try {
        URL Url = new URL(url);
         con = (HttpURLConnection) Url.openConnection();
        
        //Metodo get é padrão
        con.setRequestMethod("DELETE");
        
        //adicionar request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = con.getResponseCode();
            System.out.println("/n Sendind 'DELETE' Request to URL " + url);
            System.out.println("/n ResponseCode" + responseCode);
            
            BufferedReader in = new BufferedReader(
                            new InputStreamReader (con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while( (inputLine = in.readLine()) != null ){
            response.append(inputLine);
        }
    
        in.close();
        con.disconnect();
        //retorna resultado
        return response.toString();
        }catch(MalformedURLException ex){
            System.out.println("Erro de Url mal formada no DELETE" + ex.toString());
            return null;
        }
        catch(IOException ex){
            System.out.println("Erro de Leitura e Escrita I/O no DELETE" + ex.toString());
            return null;
            
        }
        
    }
        
    }
    
    
    

