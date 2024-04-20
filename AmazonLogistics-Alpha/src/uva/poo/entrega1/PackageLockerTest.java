/**
 * @author jimenarioja
 */

package uva.poo.entrega1;
 
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;

public class PackageLockerTest {

	
	@Test
	public void testConstructorPackageLocker() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20, 40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		assertNotNull(packageLocker);
		assertEquals(id,packageLocker.getId());
		assertNotNull(packageLocker.getGps());
		assertEquals(gps,packageLocker.getGps());
		assertNotSame(gps,packageLocker.getGps());
		assertNotNull(packageLocker.getOpeningHour());
		assertEquals(openingHour,packageLocker.getOpeningHour());
		assertTrue(packageLocker.getOpeningHour().isBefore(packageLocker.getClosingHour()));
		assertNotNull(packageLocker.getClosingHour());
		assertEquals(closingHour,packageLocker.getClosingHour());
		assertTrue(packageLocker.getClosingHour().isAfter(packageLocker.getOpeningHour()));
		assertFalse(packageLocker.isOutOfService());
	}

	
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageLockerGpsNull() {
		int id=5;
		GPSCoordinate gps=null;
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageLockerOpeningHourNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=null;
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	}	
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageLockerClosingHourNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(8, 30);
		LocalTime closingHour=null;
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPackageLockerOpeningHourNotBeforeClosingHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(12,30);
		LocalTime closingHour=LocalTime.of(10,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	}
	
	@Test
	public void testConstructorPackageLockerCopy() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8, 0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35; 
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		PackageLocker packageLockerCopy=new PackageLocker(packageLocker);
		
		assertNotNull(packageLockerCopy);
		assertEquals(packageLocker.getId(),packageLockerCopy.getId());
		assertNotNull(packageLockerCopy.getGps());
		assertNotSame(packageLocker.getGps(),packageLockerCopy.getGps());
		assertEquals(packageLocker.getGps(),packageLockerCopy.getGps());
		assertNotNull(packageLockerCopy.getOpeningHour());
		assertEquals(packageLocker.getOpeningHour(),packageLockerCopy.getOpeningHour());
		assertNotNull(packageLockerCopy.getClosingHour());
		assertEquals(packageLocker.getClosingHour(),packageLockerCopy.getClosingHour());
		assertFalse(packageLocker.isOutOfService());
		assertTrue(packageLocker.getOpeningHour().isBefore(packageLocker.getClosingHour()));
		assertEquals(packageLocker.getNumLockers(),packageLockerCopy.getNumLockers());
		assertTrue(packageLocker.getClosingHour().isAfter(packageLocker.getOpeningHour()));
	}
	
	@Test 
	public void testConstructorPackageLockerCopyPackageLockerOutOfService() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8, 0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35; 
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		packageLocker.outOfService();
		
		PackageLocker packageLockerCopy=new PackageLocker(packageLocker);
		
		assertNotNull(packageLockerCopy);
		assertEquals(packageLocker.getId(),packageLockerCopy.getId());
		assertNotNull(packageLockerCopy.getGps());
		assertNotSame(packageLocker.getGps(),packageLockerCopy.getGps());
		assertEquals(packageLocker.getGps(),packageLockerCopy.getGps());
		assertNotNull(packageLockerCopy.getOpeningHour());
		assertEquals(packageLocker.getOpeningHour(),packageLockerCopy.getOpeningHour());
		assertNotNull(packageLockerCopy.getClosingHour());
		assertEquals(packageLocker.getClosingHour(),packageLockerCopy.getClosingHour());
		assertTrue(packageLocker.isOutOfService());
		assertTrue(packageLocker.getOpeningHour().isBefore(packageLocker.getClosingHour()));
		assertEquals(packageLocker.getNumLockers(),packageLockerCopy.getNumLockers());
		assertTrue(packageLocker.getClosingHour().isAfter(packageLocker.getOpeningHour()));
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorPackageLockerCopyPackageLockerNull() {		
		PackageLocker packageLocker=null;
		
		@SuppressWarnings("unused")
		PackageLocker packageLockerCopy=new PackageLocker(packageLocker);
	}
	
	
	@Test
	public void testGettersSettersId() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		int newId=23;
		packageLocker.setId(newId);
		
		assertEquals(newId,packageLocker.getId());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersNegativeId() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		int newId=-2;
		packageLocker.setId(newId);
	}
	
	@Test
	public void testGettersSettersGps() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		GPSCoordinate newGps=new GPSCoordinate(70,110);
		packageLocker.setGps(newGps);
		
		assertNotNull(packageLocker.getGps());
		assertNotSame(newGps,packageLocker.getGps());
		assertEquals(newGps,packageLocker.getGps());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersGpsNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		GPSCoordinate newGps=null;
		packageLocker1.setGps(newGps);
	}
	
	@Test
	public void testGettersSettersOpeningHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newOpeningHour=LocalTime.of(10, 30);
		packageLocker.setOpeningHour(newOpeningHour);
		
		assertNotNull(packageLocker.getOpeningHour());
		assertNotSame(newOpeningHour,packageLocker.getOpeningHour());
		assertEquals(newOpeningHour,packageLocker.getOpeningHour());
	}
	
	
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersOpeningHourNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newOpeningHour=null;
		packageLocker.setOpeningHour(newOpeningHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersOpeningHourNotBeforeClosingHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(8,30);
		LocalTime closingHour=LocalTime.of(10,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newOpeningHour=LocalTime.of(12, 50);
		packageLocker.setOpeningHour(newOpeningHour);
	}
	
	@Test
	public void testGettersSettersClosingHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newClosingHour=LocalTime.of(19,30);
		packageLocker.setClosingHour(newClosingHour);
		
		assertNotNull(packageLocker.getClosingHour());
		assertEquals(newClosingHour, packageLocker.getClosingHour());
		assertNotSame(newClosingHour,packageLocker.getClosingHour());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGettersSettersClosingHourNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newClosingHour=null;
		packageLocker.setClosingHour(newClosingHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGettersSettersClosingHourNotAfterClosingHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(8,30);
		LocalTime closingHour=LocalTime.of(10,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalTime newClosingHour=LocalTime.of(7, 50);
		packageLocker.setClosingHour(newClosingHour);
	}
	
	@Test 
	public void testNotOutOfService() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		packageLocker.notOutOfService();
		
		assertFalse(packageLocker.isOutOfService());
	}
	
	@Test 
	public void testOutOfService() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		packageLocker.outOfService();
		
		assertTrue(packageLocker.isOutOfService());
	}
	
	@Test
	public void testGetNumLockers() {
		int size=1;
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		assertEquals(size,packageLocker.getNumLockers());
	}
	
	@Test
	public void testGetNumFullLockers() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);

		
		int numFullLockers=1;
		
		assertEquals(numFullLockers,packageLocker1.getNumFullLockers());		
	}
	
	@Test
	public void testGetNumEmptyLockers() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker locker2=new Locker(numLocker+1,width,length,height);
		Locker locker3=new Locker(numLocker+2,width,length,height);
		Locker locker4=new Locker(numLocker+3,width,length,height);
		Locker locker5=new Locker(numLocker+4,width,length,height);
		Locker lockers[]= {locker,locker2,locker3,locker4,locker5};
		
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	
		
		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker1.setPackage(package1);
		packageLocker1.setPackage(package2);
		packageLocker1.setPackage(package3);
		
		int numEmptyLockers=2;
		
		assertEquals(numEmptyLockers,packageLocker1.getNumEmptyLockers());		
	}
	
	@Test
	public void testGetLocker() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		packageLocker1.setPackage(package1);
		int index=0;
		
		assertEquals(index,packageLocker1.getLocker(id1));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetLockerIdNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		String newId=null;
		
		packageLocker1.getLocker(newId);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetLockerNotFound() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		

		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker1.setPackage(package1);
		packageLocker1.setPackage(package2);
		packageLocker1.setPackage(package3);
		
		String newId="4517937826";
		
		packageLocker1.getLocker(newId);
	}
	
	// MIRAR BIEN
	@Test
	public void testSetPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(60,120);
		LocalTime openingHour=LocalTime.of(9,15);
		LocalTime closingHour=LocalTime.of(20,40);
		
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=3;
		double length1=1;
		double height1=2;
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
			
		packageLocker1.setPackage(package1); 
		
		int index=0;

		assertEquals(packageLocker1.getPackage(index),package1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetPackageNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		Package package1=null;
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker.setPackage(package1);
		packageLocker.setPackage(package2);
		packageLocker.setPackage(package3);
		
		Package package4=null;
		
		packageLocker.setPackage(package4);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetPackageCollectedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker1.setPackage(package1);
		packageLocker1.setPackage(package2);
		
		package3.pickUpPackage();
		packageLocker1.setPackage(package3);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetPackageReturnedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker1.setPackage(package1);
		packageLocker1.setPackage(package2);
		
		package3.returnPackage();
		
		packageLocker1.setPackage(package3);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPackageNoFreeLockers() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		

		
		String id2="1846734935";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		String id3="9478346539";
		LocalDate expirationDate3=LocalDate.of(2023, 11, 30);
		double width3=30;
		double length3=50;
		double height3=20;
		
		Package package3=new Package(id3,expirationDate3,width3,length3,height3);
		
		packageLocker1.setPackage(package1);
		packageLocker1.setPackage(package2);
		packageLocker1.setPackage(package3);
		
		String id4="8253874018";
		LocalDate expirationDate4=LocalDate.of(2023, 12, 16);
		double width4=30;
		double length4=50;
		double height4=20;
		
		Package package4=new Package(id4,expirationDate4,width4,length4,height4);
		
		packageLocker1.setPackage(package4);
	}
	
	@Test
	public void testTakeOutPackageAsCustomer() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 12, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		int numLocker2=1;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker locker2=new Locker(numLocker2,width,length,height);
		Locker lockers[]= {locker,locker2};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker.setPackage(package1);
		int index=packageLocker.getLocker(id1);
		
		LocalDate pickUpDate=LocalDate.of(2023, 12, 5);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		Package package2=packageLocker.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
		assertTrue(package2.getPickUpStatus());
		assertNull(packageLocker.getLockers()[index]);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTakeOutPackageAsCustomerPackageIdNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String id22=null;
		LocalDate pickUpDate=LocalDate.of(2023, 12, 16);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		packageLocker1.takeOutPackageAsCustomer(id22,pickUpDate,pickUpHour);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTakeOutPackageAsCustomerPickUpDateNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
	
		
		packageLocker1.setPackage(package1);
		
		LocalDate pickUpDate=null;
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTakeOutPackageAsCustomerPickUpHourNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalDate pickUpDate=LocalDate.of(2023, 12, 2);
		LocalTime pickUpHour=null;
		
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerPickUpHourBeforeOpeningHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(12,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalDate pickUpDate=LocalDate.of(2023, 12, 2);
		LocalTime pickUpHour=LocalTime.of(9,0);
		
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerPickUpHourAfterClosingHour() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(12,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		LocalDate pickUpDate=LocalDate.of(2023, 12, 2); 
		LocalTime pickUpHour=LocalTime.of(22,30);
		
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerCollectedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
	
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		packageLocker1.setPackage(package1);
		
		LocalDate pickUpDate=LocalDate.of(2023, 11, 2);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		package1.pickUpPackage();
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerReturnedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		packageLocker1.setPackage(package1);
		
		LocalDate pickUpDate=LocalDate.of(2023, 11, 2);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		package1.returnPackage();
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerLate() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);
		
		LocalDate pickUpDate=LocalDate.of(2024, 11, 2);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		packageLocker1.takeOutPackageAsCustomer(id1,pickUpDate,pickUpHour);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageAsCustomerPackageNotFound() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String id11="1234567895";

		
		LocalDate pickUpDate=LocalDate.of(2023, 11, 2);
		LocalTime pickUpHour=LocalTime.of(12,30);
		
		packageLocker1.takeOutPackageAsCustomer(id11,pickUpDate,pickUpHour);
	}
	
	
	@Test
	public void testTakeOutPackageToReturn() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
				
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.takeOutPackageToReturn(package1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTakeOutPackageToReturnPackageNull() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		Package package21=null;
		
		
		packageLocker1.takeOutPackageToReturn(package21);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageToReturnReturnedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);
		
		packageLocker1.takeOutPackageToReturn(package1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageToReturnCollectedPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
			
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);
		
		package1.returnPackage();
		packageLocker1.takeOutPackageToReturn(package1);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTakeOutPackageToReturnPackageNotFound() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String id2="1234711245";
		LocalDate expirationDate2=LocalDate.of(2023, 11, 10);
		double width2=30;
		double length2=50;
		double height2=20;
		
		Package package2=new Package(id2,expirationDate2,width2,length2,height2);
		
		
		packageLocker1.takeOutPackageToReturn(package2);
	}
	
	@Test
	public void testGetPackage() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);
		int numLocker1=0;
		Package newPackage=packageLocker1.getPackage(numLocker1);
		
		assertNotNull(newPackage);
		assertEquals(newPackage,package1);
		assertNotSame(newPackage,package1);	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetPackageNegativeNumLocker() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		
		packageLocker1.setPackage(package1);
		int numLocker2=-2;
		
		@SuppressWarnings("unused")
		Package newPackage=packageLocker1.getPackage(numLocker2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetPackageBiggerNumLocker() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		packageLocker1.setPackage(package1);
		
		@SuppressWarnings("unused")
		Package newPackage=packageLocker1.getPackage(numLocker);
	}
	
	@Test
	public void testGetNewNumberOfLocker() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		int newNumberOfLocker=packageLocker1.getNewNumberOfLocker();
		
		assertNotEquals(numLocker,newNumberOfLocker);
	}
	
	@Test
	public void testExpandLockers() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		int plusLockers=3;
		int totalLockers=packageLocker1.getNumLockers()+plusLockers;
		packageLocker1.expandLockers(plusLockers);
		
		assertEquals(totalLockers,packageLocker1.getNumLockers());
	}
	
	@Test
	public void testIsFullTrue() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		assertTrue(packageLocker1.isFull());
	}
	
	@Test
	public void testIsFullFalse() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		assertFalse(packageLocker1.isFull());
	}
	
	@Test
	public void testToString() {
		int id=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		
		
		String id1="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id1,expirationDate,width1,length1,height1);
		int numLocker=2;
		double width=35;
		double length=70;
		double height=42;
		
		Locker locker=new Locker(package1,numLocker,width,length,height);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id,gps,openingHour,closingHour);
		
		String infoPackageLocker=packageLocker1.toString();
		
		assertNotNull(infoPackageLocker);
		assertNotEquals("",infoPackageLocker);
	}
	
	@Test
	public void testEqualsTrue() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int id2=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		int numLocker=2;
		
		Locker locker=new Locker(package1,numLocker,width1,length1,height1);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id2,gps,openingHour,closingHour);
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps,openingHour,closingHour);
		
		assertTrue(packageLocker1.equals(packageLocker2));
	}
	
	@Test
	public void testEqualsFalse() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int id2=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		int numLocker=2;
		int id3=9;
		
		Locker locker=new Locker(package1,numLocker,width1,length1,height1);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id2,gps,openingHour,closingHour);
		PackageLocker packageLocker2=new PackageLocker(lockers,id3,gps,openingHour,closingHour);
		
		assertFalse(packageLocker1.equals(packageLocker2));
	}
	
	@Test
	public void testEqualsTrueSameObject() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int id2=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		int numLocker=2;
		
		Locker locker=new Locker(package1,numLocker,width1,length1,height1);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id2,gps,openingHour,closingHour);
		
		assertTrue(packageLocker1.equals(packageLocker1));
	}
	
	@Test
	public void testEqualsObjectNotLocker() {
		String id="1234721145";
		LocalDate expirationDate=LocalDate.of(2023, 11, 10);
		double width1=30;
		double length1=50;
		double height1=20;
		
		Package package1=new Package(id,expirationDate,width1,length1,height1);
		int id2=5;
		GPSCoordinate gps=new GPSCoordinate(39,76);
		LocalTime openingHour=LocalTime.of(8,0);
		LocalTime closingHour=LocalTime.of(20, 0);
		int numLocker=2;
		
		Locker locker=new Locker(package1,numLocker,width1,length1,height1);
		Locker lockers[]= {locker};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id2,gps,openingHour,closingHour);
		
		assertFalse(packageLocker1.equals(locker));
	}
}

