package com.finance;

import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.ApprovalTable;
import com.finance.layer2.BankTable;
import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.ApprovalRepository;
import com.finance.layer3.BankTableRepository;
import com.finance.layer3.CardTableRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.ProductRepository;
import com.finance.layer3.RegistrationTableRepository;

@ContextConfiguration
@SpringBootTest
class FinanceProjectApplicationTests {
	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	CardTableRepository crdRepo;
	
	@Autowired
	BankTableRepository bnkRepo;
	
	@Autowired
	ApprovalRepository aprovRepo;	
	
	@Autowired
	ProductRepository prdRepo;	
	
	@Autowired
	RegistrationTableRepository regRepo;
	
	
	@Test
	void testCase1() {
		System.out.println("........");
		//System.out.println(ordRepo.findOrder(1));
		//System.out.println(e.getEmployeeJob());
		 OrderTable ord =ordRepo.findOrder(1);
		 System.out.println(ord.getProductTable().getProductName());
		 System.out.println(ord.getEmiMonths());
		 System.out.println(ord.getTotalCost());
//		ordRepo.findOrder(2);
//		System.out.println(ordRepo.findOrder(2).getEmi());	 
		}
	
	@Test
	void addTestCase2() {
		OrderTable ordadd= new OrderTable();
		ordadd.setOrdId(3);
		ordadd.setCardTable(null);
		// OrderTable add =ordRepo.addOrder(null);
	}
	@Test
	void cardTest() {
		System.out.println("Find & FindAll for Card Table");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println(crdRepo.findCard(987654321).getCustName());
		
		Set<CardTable> CardTableSet = crdRepo.findAllCard();
		
		for(CardTable ct: CardTableSet) {
			System.out.println(ct.getCustName());
		}
		System.out.println("---------------------------------------------------------------");
		System.out.println("Add row in CardTable");
		
//		CardTable ct = new CardTable();
		
		ApprovalTable at = aprovRepo.findApproval(1003);
		System.out.println(at.getCardTable().getCustName());
		
		
		
//		ct.setApprovalTable2(at);
//		
//		ct.setCardLimit(1000000.00);
//		ct.setCustName("ETHAN");
		
		//crdRepo.addCard(ct);

	}
	
	@Test
	void bankTest() {
		System.out.println("Find & FindAll for Bank Table");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println(bnkRepo.findBankTable(123456789).getRegistrationTable().getApprovalTable().get);
		
		Set<BankTable> BankTableSet = bnkRepo.findAllBankTable();
		
		for(BankTable bt: BankTableSet) {
			System.out.println(bt.getRegistrationTable().getUsername());
		}
		System.out.println("---------------------------------------------------------------");
	}
	@Test
	void testCase7() {// delete transaction
		System.out.println("..........................");
		ProductTable p1=new ProductTable();
		p1.setProductName("xxx");
		prdRepo.addProduct(p1);
		}
	
	@Test
	void TestDelete() {
		System.out.println("..........................");
		prdRepo.removeProduct(41);
	}
	
//	@Test
//	void TestAdd() {
//		System.out.println("-----------------");
//		
//		ApprovalTable app = new ApprovalTable();
//		
//		RegistrationTable reg = regRepo.findRegistrationTable();
		
		
//	    RegistrationTable reg = aprovRepo.
//	    
//		app.setApprovalStatus("NO");
//		
//		app.setCardFee(5000);
//
//		app.setRegistrationTable2(reg);
// }
	
	
//	@Test
//	void AddRegistertest() {
//		System.out.println("-----------------------------------------");
//		RegistrationTable reg = new RegistrationTable(); 
//		//reg.setRegId(4);
//		reg.setName("DHONI");
//		reg.setPhoneNo(9874561);
//		reg.setEmailId("D@sir");
//		reg.setUsername("Dhoni");
//		reg.setPassword("BATSMAN");
//		reg.setAddress("CHENAI");
//		reg.setCardType("Gold");
//		reg.setRegistrationDate(LocalDate.of(1986,7,8));
//		reg.setDob(LocalDate.of(1991,10,20));
//		reg.setAdharCard(77777);
//		regRepo.addRegistrationTable(reg);
//		System.out.println("----------------------------------------------");
//	}
	
}


