/**
 * @author jimenarioja
 */

package uva.poo.entrega1;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class LockerTest {

	@Test
	public void testConstructorLockerOnlyNumLocker() {
		int numLocker=2;
		Locker locker=new Locker(numLocker);
		
		assertNotNull(locker);
		assertEquals(locker.getNumLocker(),numLocker);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerOnlyNegativeNumLocker() {
		int numLocker=-2;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(numLocker);
	}
	
	@Test
	public void testConstructorLockerNumLockerAndPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		
		Locker locker=new Locker(numLocker,package1);
		
		assertNotNull(locker);
		assertEquals(locker.getNumLocker(),numLocker);
		assertEquals(locker.getStoredPackage(),package1);
		assertNotSame(locker.getStoredPackage(),package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerNegativeNumLockerAndPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=-2;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(numLocker,package1);
	}
	
	@Test
	public void testConstructorLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		assertNotNull(locker);
		assertEquals(numLocker,locker.getNumLocker());
		assertEquals(width,locker.getWidth(),0.5);
		assertEquals(length,locker.getLength(),0.5);
		assertEquals(height,locker.getHeight(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerNegativeNumLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=-2;
		double width=35;
		double length=70;
		double height=42;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(package1,numLocker,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerNoPositiveWidth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=-35;
		double length=70;
		double height=42;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(package1,numLocker,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerNoPositiveLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=-70;
		double height=42;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(package1,numLocker,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerNoPositiveHeight() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=-42;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(package1,numLocker,width,length,height);
	}
	
	@Test
	public void testConstructorLockerWithoutPackage() {

		double width1=30;
		double length1=50;
		double height1=20;
		int numLocker=2;
		
		Locker locker=new Locker(numLocker,width1,length1,height1);
		
		assertNotNull(locker);
		assertEquals(locker.getNumLocker(),numLocker);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerWithoutPackageNoPositiveWidth() {
		double width1=-30;
		double length1=50;
		double height1=20;
		
		int numLocker=2;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(numLocker,width1,length1,height1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerWithoutPackageNoPositiveLength() {
		double width1=30;
		double length1=-50;
		double height1=20;
		
		int numLocker=2;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(numLocker,width1,length1,height1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorLockerWithoutPackageNoPositiveHeight() {
		double width1=30;
		double length1=50;
		double height1=-20;
		
		int numLocker=2;
		
		@SuppressWarnings("unused")
		Locker locker=new Locker(numLocker,width1,length1,height1);
	}
	
	@Test
	public void testConstructorCopyLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		
		Locker locker=new Locker(package1,numLocker,width1,length1,height1);
		Locker lockerCopy=new Locker(locker);
		
		assertNotNull(lockerCopy);
		assertNotSame(locker,lockerCopy);
		assertEquals(locker.getStoredPackage(),lockerCopy.getStoredPackage());
		assertNotSame(locker.getStoredPackage(),lockerCopy.getStoredPackage());
		assertEquals(locker.getWidth(),lockerCopy.getWidth(),0.5);
		assertEquals(locker.getLength(),lockerCopy.getLength(),0.5);
		assertEquals(locker.getHeight(),lockerCopy.getHeight(),0.5);
	}
	
	@Test
	public void testGettersSettersStoredPackage() {
		String id1="1234721145";
		LocalDate expirationDate1=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate1,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234711245";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package newPackage=new Package(id2,expirationDate2,width2,length2,height2);
		
		locker.setStoredPackage(newPackage);
		assertEquals(newPackage,locker.getStoredPackage());
		assertNotSame(newPackage,locker.getStoredPackage());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersStoredPackageCollected() {
		String id1="1234721145";
		LocalDate expirationDate1=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate1,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234711245";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package newPackage=new Package(id2,expirationDate2,width2,length2,height2);
		newPackage.pickUpPackage();
		
		locker.setStoredPackage(newPackage);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersStoredPackageReturned() {
		String id1="1234721145";
		LocalDate expirationDate1=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate1,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234711245";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package newPackage=new Package(id2,expirationDate2,width2,length2,height2);
		newPackage.returnPackage();
		
		locker.setStoredPackage(newPackage);
	}
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersStoredPackageNull() {
		String id1="1234721145";
		LocalDate expirationDate1=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate1,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		Package newPackage=null;
		
		locker.setStoredPackage(newPackage);
	}
	
	@Test
	public void testGettersSettersNumLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		int newNumLocker=23;
		locker.setNumLocker(newNumLocker);
		
		assertEquals(newNumLocker,locker.getNumLocker());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersNegativeNumLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		int newNumLocker=-5;
		locker.setNumLocker(newNumLocker);
	}
	
	@Test
	public void testGettersSettersWidth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newWidth=50;
		locker.setWidth(newWidth);
		
		assertEquals(newWidth,locker.getWidth(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersNoPositiveWidth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newWidth=-50;
		locker.setWidth(newWidth);
	}
	
	@Test
	public void testGettersSettersLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newLength=50;
		locker.setLength(newLength);
		
		assertEquals(newLength,locker.getLength(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersNoPositiveLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newLength=-50;
		locker.setLength(newLength);
	}
	
	@Test
	public void testGettersSettersHeight() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
			
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newHeight=50;
		locker.setHeight(newHeight);
		
		assertEquals(newHeight,locker.getHeight(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersNoPositiveWHeigth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		double newHeigth=-50;
		locker.setHeight(newHeigth);
	}
	
	@Test
	public void testToString() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String infoLocker=locker.toString();
		
		assertNotNull(infoLocker);
		assertNotEquals("",infoLocker);
	}
	
	@Test
	public void testEqualsTrue() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234721145";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		int numLocker2=2;
		double width12=35;
		double length12=70;
		double height12=42;
		
		Locker locker2=new Locker(package2,numLocker2,width12,length12,height12);
		
		assertTrue(locker.equals(locker2));
	}
	
	@Test
	public void testEqualsFalse() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234721145";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		int numLocker2=6;
		double width12=35;
		double length12=70;
		double height12=42;
		
		Locker locker2=new Locker(package2,numLocker2,width12,length12,height12);
		
		assertFalse(locker.equals(locker2));
	}
	
	@Test
	public void testEqualsTrueSameObject() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		assertTrue(locker.equals(locker));
	}
	
	@Test
	public void testEqualsObjectNotLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		String id2="1234721145";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		assertFalse(locker.equals(package2));
	}

}
