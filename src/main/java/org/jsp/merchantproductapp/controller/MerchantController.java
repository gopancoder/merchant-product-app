package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {
	public static void main(String[] args) {
		MerchantDao merchantDao = new MerchantDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("===========PRODUCT CART============");

		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find Merchant By Id");
		System.out.println("4.Verify Merchant By Phone and Password");
		System.out.println("5.Verify Merchant By email and password");
		System.out.println();
		System.out.println("Enter your choice:");
		switch (sc.nextInt()) {
		case 1: {
			Merchant merchant = new Merchant();
			System.out.println("Enter name,email,phone,gst number,password of merchant");
			merchant.setName(sc.next());
			merchant.setEmail(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setGst_number(sc.next());
			merchant.setPassword(sc.next());
			merchant = merchantDao.saveMerchant(merchant);
			System.out.println("Merchant saved with id:" + merchant.getId());
			break;
		}
		case 2: {
			Merchant merchant = new Merchant();
			System.out.println("Enter id,name,email,phone,gst number,password of merchant");
			merchant.setId(sc.nextInt());
			merchant.setName(sc.next());
			merchant.setEmail(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setGst_number(sc.next());
			merchant.setPassword(sc.next());
			merchant = merchantDao.updateMerchant(merchant);
			if (merchant != null) {
				System.out.println("Merchant Updated with id:" + merchant.getId());
			} else {
				System.err.println("Invalid merchant id..!!");
			}
			break;
		}
		case 3: {
			System.out.println("Enter Merchant id:");
			int id = sc.nextInt();
			Merchant merchant = merchantDao.findMerchantById(id);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invlaid merchant id..!!");
			}
			break;
		}
		case 4: {
			System.out.println("Enter the Phone number and password to verify");
			long phone = sc.nextLong();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(phone, password);
			if (merchant != null) {
				System.out.println("Verified successfully..!!");
				System.out.println(merchant);
			} else {
				System.err.println("Invalid phone number or password..!!");
			}
			break;
		}
		case 5: {
			System.out.println("Enter the email number and password to verify");
			String email = sc.next();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(email, password);
			if (merchant != null) {
				System.out.println("Verified successfully..!!");
				System.out.println(merchant);
			} else {
				System.err.println("Invalid email or password..!!");
			}
			break;
		}
		default: {
			sc.close();
			System.err.println("Invalid choice number..!!");
		}
		}
	}

}
