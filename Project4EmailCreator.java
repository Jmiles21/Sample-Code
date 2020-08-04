/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4emailcreator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jaylonmiles
 */
public class Project4EmailCreator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        // Read the template file using BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("template.txt"));
		//Storing First Name and Email ids
		String[] csvs = {"james , butler, jbutler@gmail.com",
						"Josephine, Darakjy, Josephine_Darakjy@darakjy.org",
						"ART,VENERE,ART@VENERE.ORG"};
		//Store the Read data
		String emailData = "";
		//Exception Handling
		try {
		StringBuilder sb = new StringBuilder();
		//Read the First line from the file 
		String line = br.readLine();
		//Read the remaing lines till the End Of File
		while (line != null) {
        sb.append(line);
		sb.append("\n");
		line = br.readLine();
		}
		 emailData = sb.toString();
		} finally {
		br.close();
		}
		//This template stores the data from the file
		String template = emailData;
		
		//Read each of the email ids 
		for (String csv : csvs) {
			//Split the individual array element to get the first name and email id  
			String[] t1 = csv.split(",");
			//Email to lowercase
			String email = t1[2].toLowerCase();
			String first_name = t1[0].toLowerCase();
			//First name to title case 
			first_name = first_name.substring(0, 1).toUpperCase()+first_name.substring(1).toLowerCase();
			String txt = template.replace("{first_name}",first_name );
			txt = txt.replace("{email}",email);
			System.out.println(txt);
			System.out.println("\n===============================================================\n");
		}
    }
    
}
