package com.assignment.payslip.domain;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import com.assignment.payslip.tax.TaxCalculation2012To2013;
import com.assignment.payslip.util.ApplicationProperties;

public class TaxCalculation2012To2013Test {
	
    private static Properties properties;
	
	@BeforeClass
	public  static void loadProperties() {
		properties=ApplicationProperties.getInstance().load();
	}

	@Test
	public void annualSalaryWith60050ShouldReturn922() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(60050).intValue(),922);
		
	}
	
	@Test
	public void annualSalaryWith120000ShouldReturn2696() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(120000).intValue(),2696);
	}
	
	@Test
	public void annualSalaryWith0ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(0).intValue(),0);
	}
	
	@Test
	public void annualSalaryWith999ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(999).intValue(),0);
	}
	
	@Test
	public void annualSalaryWith18200ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		tax.getTaxAmount(60050);
		assertEquals(tax.getTaxAmount(18200).intValue(),0);
	}
	
	@Test
	public void annualSalaryWith37000ShouldReturn298() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(37000).intValue(),298);
	}
	
	@Test
	public void annualSalaryWith37001ShouldReturn298() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(37001).intValue(),298);
	}
	
	@Test
	public void annualSalaryWith80000ShouldReturn1462() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(80000).intValue(),1462);
	}
	
	@Test
	public void annualSalaryWith55555ShouldReturn800() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		tax.getTaxAmount(60050);
		assertEquals(tax.getTaxAmount(55555).intValue(),800);
	}
	
	@Test
	public void annualSalaryWith80001ShouldReturn1462() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(80001).intValue(),1462);
	}
	
	@Test
	public void annualSalaryWith99999ShouldReturn2079() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		tax.getTaxAmount(60050);
		assertEquals(tax.getTaxAmount(99999).intValue(),2079);
	}
	
	@Test
	public void annualSalaryWith180000ShouldReturn4546() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(180000).intValue(),4546);
	}
	
	@Test
	public void annualSalaryWith180001ShouldReturn4546() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		assertEquals(tax.getTaxAmount(180001).intValue(),4546);
	}
	
	@Test
	public void annualSalaryWith199999ShouldReturn5296() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013(properties);
		tax.getTaxAmount(60050);
		assertEquals(tax.getTaxAmount(199999).intValue(),5296);
	}

}
