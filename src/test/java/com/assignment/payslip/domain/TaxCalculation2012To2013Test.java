package com.assignment.payslip.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assignment.payslip.tax.TaxCalculation2012To2013;

public class TaxCalculation2012To2013Test {

	@Test
	public void annualSalaryWith60050ShouldReturn922() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(60050)),922);
		
	}
	
	@Test
	public void annualSalaryWith120000ShouldReturn2696() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(120000)),2696);
	}
	
	@Test
	public void annualSalaryWith0ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(0)),0);
	}
	
	@Test
	public void annualSalaryWith999ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(999)),0);
	}
	
	@Test
	public void annualSalaryWith18200ShouldReturn0() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		tax.getTaxAmount(60050);
		assertEquals(Math.round(tax.getTaxAmount(18200)),0);
	}
	
	@Test
	public void annualSalaryWith37000ShouldReturn298() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(37000)),298);
	}
	
	@Test
	public void annualSalaryWith37001ShouldReturn298() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(37001)),298);
	}
	
	@Test
	public void annualSalaryWith80000ShouldReturn1462() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(80000)),1462);
	}
	
	@Test
	public void annualSalaryWith55555ShouldReturn800() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		tax.getTaxAmount(60050);
		assertEquals(Math.round(tax.getTaxAmount(55555)),800);
	}
	
	@Test
	public void annualSalaryWith80001ShouldReturn1462() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(80001)),1462);
	}
	
	@Test
	public void annualSalaryWith99999ShouldReturn2079() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		tax.getTaxAmount(60050);
		assertEquals(Math.round(tax.getTaxAmount(99999)),2079);
	}
	
	@Test
	public void annualSalaryWith180000ShouldReturn4546() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(180000)),4546);
	}
	
	@Test
	public void annualSalaryWith180001ShouldReturn4546() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		assertEquals(Math.round(tax.getTaxAmount(180001)),4546);
	}
	
	@Test
	public void annualSalaryWith199999ShouldReturn5296() {
		TaxCalculation2012To2013 tax=new TaxCalculation2012To2013();
		tax.getTaxAmount(60050);
		assertEquals(Math.round(tax.getTaxAmount(199999)),5296);
	}

}
