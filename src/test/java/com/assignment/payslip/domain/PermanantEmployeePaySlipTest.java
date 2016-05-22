package com.assignment.payslip.domain;

import static org.junit.Assert.*;

import java.util.Properties;
import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.payslip.domain.PermanentEmployeePaySlip;
import com.assignment.payslip.tax.TaxCaluculation;
import com.assignment.payslip.tax.TaxFactory;
import com.assignment.payslip.util.AppicationProperties;

public class PermanantEmployeePaySlipTest {
	
	
	private static Properties properties;
	private static TaxCaluculation taxCaluculation;
	
	@BeforeClass
	public static void loadPropertiesAndTaxImplementation() {
		properties = AppicationProperties.getinstance().load();
		taxCaluculation=TaxFactory.getInstance(properties).getTaxImplementation();
	}
	

	@Test
	public void annualSalaryWith60050() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(60050);
		emp1.setSuperRate(0.09f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),5004);
		assertEquals(emp1.calculateIncomeTax(),922);
		assertEquals(emp1.calculateNetIncome(),4082);
		assertEquals(emp1.calculateSupper(),450);
	}
	
	@Test
	public void annualSalaryWith120000() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(120000);
		emp1.setSuperRate(0.1f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),10000);
		assertEquals(emp1.calculateIncomeTax(),2696);
		assertEquals(emp1.calculateNetIncome(),7304);
		assertEquals(emp1.calculateSupper(),1000);
	}
	
	@Test
	public void annualSalaryWith0() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(0);
		emp1.setSuperRate(0.1f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),0);
		assertEquals(emp1.calculateIncomeTax(),0);
		assertEquals(emp1.calculateNetIncome(),0);
		assertEquals(emp1.calculateSupper(),0);
	}
	
	@Test
	public void annualSalaryWith999() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(999);
		emp1.setSuperRate(0.09f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),83);
		assertEquals(emp1.calculateIncomeTax(),0);
		assertEquals(emp1.calculateNetIncome(),83);
		assertEquals(emp1.calculateSupper(),7);
	}
	
	@Test
	public void annualSalaryWith18200() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(18200);
		emp1.setSuperRate(0.11f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),1517);
		assertEquals(emp1.calculateIncomeTax(),0);
		assertEquals(emp1.calculateNetIncome(),1517);
		assertEquals(emp1.calculateSupper(),167);
	}
	
	@Test
	public void annualSalaryWith37000() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(37000);
		emp1.setSuperRate(0.11f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),3083);
		assertEquals(emp1.calculateIncomeTax(),298);
		assertEquals(emp1.calculateNetIncome(),2785);
		assertEquals(emp1.calculateSupper(),339);
	}
	
	@Test
	public void annualSalaryWith37001() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(37001);
		emp1.setSuperRate(0.08f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),3083);
		assertEquals(emp1.calculateIncomeTax(),298);
		assertEquals(emp1.calculateNetIncome(),2785);
		assertEquals(emp1.calculateSupper(),247);
	}
	
	@Test
	public void annualSalaryWith80000() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(80000);
		emp1.setSuperRate(0.08f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),6667);
		assertEquals(emp1.calculateIncomeTax(),1462);
		assertEquals(emp1.calculateNetIncome(),5205);
		assertEquals(emp1.calculateSupper(),533);
	}
	
	@Test
	public void annualSalaryWith55555() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(55555);
		emp1.setSuperRate(0.33f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),4630);
		assertEquals(emp1.calculateIncomeTax(),800);
		assertEquals(emp1.calculateNetIncome(),3830);
		assertEquals(emp1.calculateSupper(),1528);
	}
	
	@Test
	public void annualSalaryWith80001() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(80001);
		emp1.setSuperRate(0.33f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),6667);
		assertEquals(emp1.calculateIncomeTax(),1462);
		assertEquals(emp1.calculateNetIncome(),5205);
		assertEquals(emp1.calculateSupper(),2200);
	}
	
	@Test
	public void annualSalaryWith99999() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(99999);
		emp1.setSuperRate(0.33f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),8333);
		assertEquals(emp1.calculateIncomeTax(),2079);
		assertEquals(emp1.calculateNetIncome(),6254);
		assertEquals(emp1.calculateSupper(),2750);
	}
	
	@Test
	public void annualSalaryWith180000() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(180000);
		emp1.setSuperRate(0.33f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),15000);
		assertEquals(emp1.calculateIncomeTax(),4546);
		assertEquals(emp1.calculateNetIncome(),10454);
		assertEquals(emp1.calculateSupper(),4950);
	}
	
	@Test
	public void annualSalaryWith180001() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(180001);
		emp1.setSuperRate(0.11f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),15000);
		assertEquals(emp1.calculateIncomeTax(),4546);
		assertEquals(emp1.calculateNetIncome(),10454);
		assertEquals(emp1.calculateSupper(),1650);
	}
	
	@Test
	public void annualSalaryWith199999() {
		PermanentEmployeePaySlip emp1=new PermanentEmployeePaySlip();
		emp1.setTaxCaluculation(taxCaluculation);
		emp1.setFirstName("David");
		emp1.setLastName("Rudd");
		emp1.setAnnualSalary(199999);
		emp1.setSuperRate(0.11f);
		emp1.setPaymentStartDate("01 March – 31 March");
		
		assertEquals(emp1.calculateGrossIncome(),16667);
		assertEquals(emp1.calculateIncomeTax(),5296);
		assertEquals(emp1.calculateNetIncome(),11371);
		assertEquals(emp1.calculateSupper(),1833);
	}
	
	
	

}
