/*����*/
import java.net.*;
import java.time.*;
import java.lang.*;
import java.util.*;
import com.google.gson.*;

class Module{
	String			module;			//�������� ������
	Duration		moduleUsage;	//������������ �������������
	long			peopleCnt;		//���������� �������������, ������������ ������
	
	Module(){
		module 	 = null;
		moduleUsage = null;
		peopleCnt = -1;
	}
	Module(String Module,
		   Duration ModuleUsage,
		   long PeopleCnt){
		module 	 = Module;
		moduleUsage = ModuleUsage;
		peopleCnt = PeopleCnt;
	}
}

class Address{
	String 			region;			//������
	String 			city;			//�����
	String 			district;		//�����
	String 			country;		//������
	Address(){
		country	 = null;
		region	 = null;
		city	 = null;
		district = null;
	}
	
	Address(String Country,
			String City){
		country = Country;
		region = Country.substring(0, 3).toUpperCase();
		city = City;
	}
	
	Address(String Country,
			String Region,
			String City){
		country = Country;
		region = Region;
		city = City;
	}
	Address(String Country,
			String Region,
			String City,
			String District){
		country	 = Country;
		region	 = Region;
		city	 = City;
		district = District;
	}
}

public class ClientData {
	Inet4Address	clientIp;		//IP ����� �������
	long			uniqKey;		//���������� ���� ����������
	Duration		fullUsage;		//������������ ������������� ���������
	ArrayList<Module>	modules;	//���� �������, ������� ���������� ������������
	Address			addr;			//����� ������� 
	
	ClientData(){
		Inet4Address	clientIp = (Inet4Address) Inet4Address.getLoopbackAddress();		
		long			uniqKey  = -1;			
		Duration		fullUsage= Duration.ZERO;		
		ArrayList<Module>	modules	 = new ArrayList<Module>();		
		Address			addr	 = new Address();			 
	}
	
	ClientData(String Host,
			   long UniqKey,
			   Duration FullUsage,
			   ArrayList<Module> Modules,
			   Address Addr){
		try {
			clientIp = (Inet4Address) Inet4Address.getByName(Host);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		uniqKey  = UniqKey;				
		fullUsage= Duration.parse(FullUsage.toString());		
		modules	 = Modules;		
		addr	 = Addr;			 
	}
}