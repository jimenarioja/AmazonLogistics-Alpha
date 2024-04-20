/**
 * @author jimenarioja
 */

package uva.poo.entrega1;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PackageTest {
  
	@Test
	public void testConstructorPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		 
		assertNotNull(package1);
		assertNotNull(package1.getId());
		assertNotNull(package1.getExpirationDate());
		assertEquals(id,package1.getId());
		assertEquals(expirationDate,package1.getExpirationDate());
		assertNotSame(expirationDate,package1.getExpirationDate());
		assertFalse(package1.getPickUpStatus());
		assertFalse(package1.getReturnStatus());
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageIdNull() {
		String id=null;
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused") 
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageIdKeyDigitWrong() {
		String id="1234721148";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused")
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageLongerIdLength() {
		String id="1234567890987654321";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused")
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageShorterIdLength() {
		String id="123";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused")
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageIdWithLetter() {
		String id="1m3j7l1ro5";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused")
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageExpirationDateNull() {
		String id="1234721145";
		LocalDate expirationDate=null;
		double width=30;
		double length=50;
		double height=20;
		
		@SuppressWarnings("unused")
		Package package1=new Package(id,expirationDate,width,length,height);
	}
	
	@Test
	public void testConstructorPackageCopy() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		Package package2=new Package(package1);
		
		assertNotNull(package2);
		assertNotNull(package2.getId());
		assertNotNull(package2.getExpirationDate());
		assertNotSame(package1,package2);
		assertEquals(package1.getId(),package2.getId());
		assertNotSame(package1.getExpirationDate(),package2.getExpirationDate());
		assertEquals(package1.getExpirationDate(),package2.getExpirationDate());
		assertEquals(package1.getPickUpStatus(),package2.getPickUpStatus());
		assertEquals(package1.getReturnStatus(),package2.getReturnStatus());
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageCopyIdNull() {
		String id=null;
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageCopyIdKeyDigitWrong() {
		String id="1234721140";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageCopyLongerIdLength() {
		String id="123456789099754321";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageCopyShorterIdLength() {
		String id="123";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageCopyIdWithLetter() {
		String id="12a47c1o45";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageCopyExpirationDateNull() {
		String id="1234721145";
		LocalDate expirationDate=null;
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		@SuppressWarnings("unused")
		Package package2=new Package(package1);
	}
	
	@Test
	public void testGettersSettersId() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo="1833622926";
		
		package1.setId(idNuevo);
		
		assertNotNull(package1.getId());
		assertEquals(idNuevo,package1.getId()); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersIdNull() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo=null;
		
		package1.setId(idNuevo);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersIdKeyDigitWrong() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo="1234721147";
		
		package1.setId(idNuevo);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersIdWithCharacters() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo="1j34r2m1t7";
		
		package1.setId(idNuevo);
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersIdLongerLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo="1234567890987654321";
		
		package1.setId(idNuevo);
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersIdShorterLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		String idNuevo="123";
		
		package1.setId(idNuevo);
	}
	
	
	@Test
	public void testGettersSettersExpirationDate() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newExpirationDate=LocalDate.of(2022, 9, 23);
		package1.setExpirationDate(newExpirationDate);
		assertNotNull(package1.getExpirationDate());
		assertNotSame(newExpirationDate,package1.getExpirationDate());
		assertEquals(newExpirationDate,package1.getExpirationDate());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersExpirationDateNull() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newExpirationDate=null;
		
		package1.setExpirationDate(newExpirationDate);
	}
	
	@Test
	public void testGettersSettersPickUpStatusFalseToTrue() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		package1.pickUpPackage();
		assertTrue(package1.getPickUpStatus());
	}

	@Test
	public void testGettersSettersReturnStatusFalseToTrue() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		package1.returnPackage();
		assertTrue(package1.getReturnStatus());
	}
	
	@Test
	public void testGettersSettersWidth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newWidth=45;
		package1.setWidth(newWidth);
		
		assertEquals(newWidth,package1.getWidth(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSetterNoPositiveWidth() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newWidth=-45;
		package1.setWidth(newWidth);
	}
	

	@Test
	public void testGettersSettersLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newLength=45;
		package1.setLength(newLength);
		
		assertEquals(newLength,package1.getLength(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSetterNoPositiveLength() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newLenght=-45;
		package1.setLength(newLenght);
	}
	
	@Test
	public void testGettersSettersHeight() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newHeight=45;
		package1.setHeight(newHeight);
		
		assertEquals(newHeight,package1.getHeight(),0.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSetterNoPositiveHeight() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		double newHeight=-45;
		package1.setHeight(newHeight);
	}
	
	@Test
	public void testOutOfTimeOnTime() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newDate=LocalDate.of(2023, 11, 9);
		
		assertFalse(package1.outOfTime(newDate));
	}
	
	@Test
	public void testOutOfTimeDateLater() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newDate=LocalDate.of(2023, 11, 11);
		
		assertTrue(package1.outOfTime(newDate));
	}
	
	public void testOutOfTimeLastDay() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newDate=LocalDate.of(2023, 11, 10);
		
		assertFalse(package1.outOfTime(newDate));
	}
	
	@Test(expected=NullPointerException.class)
	public void testOutOfTimeDateNull() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		LocalDate newDate=null;
		
		package1.outOfTime(newDate);
	}
	
	@Test
	public void testPickUpPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.pickUpPackage();
		
		assertTrue(package1.getPickUpStatus());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPickUpPackageCollected() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.pickUpPackage(); 
		package1.pickUpPackage();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPickUpPackageReturned() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.returnPackage();
		package1.pickUpPackage(); 
	}
	
	@Test
	public void testNotPickUpPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.notPickUpPackage();
		
		assertFalse(package1.getPickUpStatus());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNotPickUpPackageCollected() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.pickUpPackage();
		package1.notPickUpPackage();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNotPickUpPackageReturned() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.returnPackage();
		package1.notPickUpPackage();
	}
	
	@Test
	public void testReturnPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.returnPackage();
		
		assertTrue(package1.getReturnStatus());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReturnPackageCollected() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.pickUpPackage();
		package1.returnPackage();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReturnPackageReturned() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.returnPackage();
		package1.returnPackage();
	}
	
	@Test
	public void testNotReturnPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.notReturnPackage();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNotReturnPackageCollected() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.pickUpPackage();
		package1.notReturnPackage();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNotReturnPackageReturned() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		package1.returnPackage();
		package1.notReturnPackage();
	}
	
	@Test
	public void testDelayPickUpDay() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		int increaseOfDays=4;
		package1.delayPickUpDay(increaseOfDays);
		LocalDate newExpirationDate=expirationDate.plusDays(increaseOfDays);
		assertNotNull(package1.getExpirationDate());
		assertEquals(newExpirationDate,package1.getExpirationDate());
		assertNotSame(newExpirationDate,package1.getExpirationDate());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDelayPickUpDayPackageCollected() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		int increaseOfDays=4;
		package1.pickUpPackage();
		package1.delayPickUpDay(increaseOfDays);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDelayPickUpDayPackageReturned() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		int increaseOfDays=4;
		package1.returnPackage();
		package1.delayPickUpDay(increaseOfDays);
	}
	
	@Test
	public void testToString() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		String infoPackage1=package1.toString();
		
		assertNotNull(infoPackage1);
		assertNotEquals("",infoPackage1);
	}
	
	@Test
	public void testEqualsTrue() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		String id2="1234721145";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		assertTrue(package1.equals(package2));
	}
	
	@Test
	public void testEqualsFalse() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		String id2="1234712145";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		assertFalse(package1.equals(package2));
	}
	
	@Test
	public void testEqualsTrueSameObject() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		assertTrue(package1.equals(package1));
	}
	
	@Test
	public void testEqualsObjectNotPackage() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width=30;
		double length=50;
		double height=20;
		
		Package package1=new Package(id,expirationDate,width,length,height);
		
		int numLocker=2;
		Locker locker=new Locker(numLocker);
		assertFalse(package1.equals(locker));
	}
}
