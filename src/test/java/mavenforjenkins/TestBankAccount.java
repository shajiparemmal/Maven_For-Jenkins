package mavenforjenkins;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void testDepositAmount() {
		BankAccount oAccount = new BankAccount();
		assertEquals(0, oAccount.getBalance(), 0);
		assertTrue(oAccount.depositAmount(100));
		assertFalse(oAccount.depositAmount(-1));
		assertFalse(oAccount.depositAmount(0));
	}

	@Test
	public void testWithdrawAmount() {
		BankAccount oAccount = new BankAccount();
		assertFalse(oAccount.withdrawAmount(100));
		oAccount.depositAmount(100);
		assertFalse(oAccount.withdrawAmount(-10));
		assertFalse(oAccount.withdrawAmount(150));
		assertFalse(oAccount.withdrawAmount(0));
	}

	@Test
	public void testGetBalance() {
		BankAccount oAccount = new BankAccount();
		oAccount.depositAmount(100);
		assertEquals(100, oAccount.getBalance(), 0);
	}

	@Test
	public void testTransferFunds() {
		BankAccount oSourceAccount = new BankAccount();
		BankAccount oDestAccount = new BankAccount();
		oSourceAccount.depositAmount(150);
		
		assertFalse(oSourceAccount.transferFunds(oDestAccount, 0));
		assertFalse(oSourceAccount.transferFunds(oDestAccount, 200));
		
		assertTrue(oSourceAccount.transferFunds(oDestAccount, 50));
		assertEquals(100, oSourceAccount.getBalance(), 0);
		assertEquals(50, oDestAccount.getBalance(), 0);
	}

}
