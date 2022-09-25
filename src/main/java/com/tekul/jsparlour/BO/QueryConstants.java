package com.tekul.jsparlour.BO;

public class QueryConstants {
	public static String schema="\"practiceTekulDev\"";
	public static String table1="js_parlour_customer_data";
	public static String seq1="js_parlour_customer_seq";
	public static String getAllQuery="Select * from "+schema+"."+table1;
	
	public static String addQuery="Insert into "+schema+"."+table1
			+"(customer_key,first_name,last_name,phone_number,address) "
			+"Values (:customerId, :firstName, :lastName, :phoneNumber, :address)";
	
	public static String getNextSeq="SELECT nextval('"+schema+"."+seq1+"')";
}
