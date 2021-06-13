package temp;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Test {

    /*
     * Complete the 'sortOrders' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY orderList as parameter.
     */

    public static List<String> sortOrders(List<String> orderList) {
    // Write your code here
        List<String> primeOrders = new ArrayList<>();
        LinkedHashSet<String> nonPrimeOrders = new LinkedHashSet<>();
        for (String order : orderList) {
            String orderType = order.split(" ")[1];
            try {
                int orderNum = Integer.parseInt(orderType);
                nonPrimeOrders.add(order);
            } catch (Exception e) {
                primeOrders.add(order);
            }
        }
        Collections.sort(primeOrders, new Comparator<String>() {
        
           @Override
            public int compare(String s1, String s2) {
                String[] s1Elements = s1.split(" ");
                String[] s2Elements = s2.split(" ");
                int i = 1;
                while (i < s1Elements.length && i < s2Elements.length) {
                    if (!s1Elements[i].equals(s2Elements[i])) {
                        return s1Elements[i].compareTo(s2Elements[i]);
                    }
                    i++;
                }
                if (i < s1Elements.length) {
                    return 1;
                }
                if (i < s2Elements.length) {
                    return -1;
                }
                return s1Elements[0].compareTo(s2Elements[0]);
            }
        
        });
        for (String nonPrimeOrder : nonPrimeOrders) {
            primeOrders.add(nonPrimeOrder);
        }
        return primeOrders;
    }
    
    public static void main(String[] args) {
		String test = "{\") coronary artery\":{\"specialities\":[{\"jhh_speciality_id\":600,\"name\":\"Neurology\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"175 pounds\":{\"specialities\":[{\"jhh_speciality_id\":400,\"name\":\"Nephrology (Kidney Specialist)\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"ab fat\":{\"specialities\":[{\"jhh_speciality_id\":400,\"name\":\"Nephrology (Kidney Specialist)\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"}]},\"ab separation\":{\"specialities\":[{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"abandoned\":{\"specialities\":[{\"jhh_speciality_id\":400,\"name\":\"Nephrology (Kidney Specialist)\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"abdominal\":{\"specialities\":[{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"abdominal discomfort\":{\"specialities\":[{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"abdominal distension\":{\"specialities\":[{\"jhh_speciality_id\":400,\"name\":\"Nephrology (Kidney Specialist)\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"}]},\"abdominal pain\":{\"specialities\":[{\"jhh_speciality_id\":400,\"name\":\"Nephrology (Kidney Specialist)\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"}]},\"abduction\":{\"specialities\":[{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"acidity\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":69,\"name\":\"Gastroenterology\"}]},\"anxiety\":{\"specialities\":[{\"jhh_speciality_id\":62,\"name\":\"Psychiatry\"}]},\"blood in urine\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":70,\"name\":\"Urology\"}]},\"body pains\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":65,\"name\":\"Rheumatology\"},{\"jhh_speciality_id\":62,\"name\":\"Psychiatry\"}]},\"breast pain\":{\"specialities\":[]},\"breathlessness\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":38,\"name\":\"Pulmonology\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"burning urination\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":70,\"name\":\"Urology\"}]},\"chest discomfort\":{\"specialities\":[{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"},{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"chest pain\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"cold\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"constipation\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":69,\"name\":\"Gastroenterology\"}]},\"contraception\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"cough\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"difficulty in swallowing\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"},{\"jhh_speciality_id\":62,\"name\":\"Psychiatry\"}]},\"discharge from urine\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":70,\"name\":\"Urology\"}]},\"dizziness\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"eye pain\":{\"specialities\":[]},\"fast heart beat\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":142,\"name\":\"Cardiology (Heart Specialist)\"}]},\"fever\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"headache\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"heartburn\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":69,\"name\":\"Gastroenterology\"}]},\"heavy menstrual bleeding (clots)\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"hot flashes\":{\"specialities\":[]},\"itching\":{\"specialities\":[{\"jhh_speciality_id\":50,\"name\":\"Dermatology (Skin Specialist)\"},{\"jhh_speciality_id\":69,\"name\":\"Gastroenterology\"}]},\"loose motion\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"menstrual cramps\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"menopause-like symptoms\":{\"specialities\":[]},\"miscarriage\":{\"specialities\":[]},\"nausea\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"nipple discharge\":{\"specialities\":[]},\"pain in the legs\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"pain on swallowing\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":69,\"name\":\"Gastroenterology\"},{\"jhh_speciality_id\":600,\"name\":\"Neurology\"}]},\"pain on urination\":{\"specialities\":[{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":70,\"name\":\"Urology\"}]},\"patches\":{\"specialities\":[{\"jhh_speciality_id\":50,\"name\":\"Dermatology (Skin Specialist)\"},{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"},{\"jhh_speciality_id\":65,\"name\":\"Rheumatology\"}]},\"pigmentation\":{\"specialities\":[{\"jhh_speciality_id\":50,\"name\":\"Dermatology (Skin Specialist)\"},{\"jhh_speciality_id\":104,\"name\":\"GP/IM\"}]},\"post menopausal bleeding\":{\"specialities\":[]}}";
		test = test.replace("\\", "");
		System.out.println(test);
	}

}

class Solution {

}