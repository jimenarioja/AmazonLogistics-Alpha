/**
 * @author jimenarioja
 */

package uva.poo.entrega1;

import static org.junit.Assert.*;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;

public class PickingPointsSystemTest {

	@Test
	public void testConstructorDefaultPickingPointsSystem() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		assertNotNull(pickingPointsSystem);
	}
	 
	@Test
	public void testConstructorCopyPickingPointsSystem() {
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20, 40);	 
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=7;
		GPSCoordinate gps2=new GPSCoordinate(60,120);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20, 40);
				
				
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		List<PackageLocker> packageLockers=new ArrayList<>();
		packageLockers.add(packageLocker1);
		packageLockers.add(packageLocker2);
		
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem(packageLockers);
		
		PickingPointsSystem pickingPointsSystemCopy=new PickingPointsSystem(pickingPointsSystem);
		
		assertNotNull(pickingPointsSystemCopy);
		assertNotSame(pickingPointsSystem,pickingPointsSystemCopy);
		assertEquals(pickingPointsSystem,pickingPointsSystemCopy);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorCopyPickingPointsSystemNull() {
		PickingPointsSystem pickingPointsSystem=null;
		
		@SuppressWarnings("unused")
		PickingPointsSystem pickingPointsSystemCopy=new PickingPointsSystem(pickingPointsSystem);
	}
	
	@Test
	public void testConstructorPickingPointsSystemPackageLockers() {
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=17;
		GPSCoordinate gps2=new GPSCoordinate(54,132);
		LocalTime openingHour2=LocalTime.of(9,0);
		LocalTime closingHour2=LocalTime.of(20,30);
		
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		List<PackageLocker> packageLockers=new ArrayList<>();
		packageLockers.add(packageLocker1);
		packageLockers.add(packageLocker2);
		
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem(packageLockers);
		assertNotNull(pickingPointsSystem);
		assertEquals(pickingPointsSystem.getPackageLockers(),packageLockers);
		assertNotSame(pickingPointsSystem.getPackageLockers(),packageLockers);
	}
	
	@Test
	public void testAddPackageLocker() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
			
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		 
		PackageLocker packageLocker=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker);
	}

	
	@Test(expected=NullPointerException.class)
	public void testAddPackageLockerNull() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		PackageLocker packageLocker=null;
		
		pickingPointsSystem.addPackageLocker(packageLocker);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddPackageLockerIsOnList() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
				
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker);
		pickingPointsSystem.addPackageLocker(packageLocker);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddPackageLockerSameGps() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
				
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
				
		PackageLocker packageLocker2=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
	}
	
	@Test
	public void testRemovePackageLocker() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};			
		
		PackageLocker packageLocker=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker);
	
		pickingPointsSystem.removePackageLocker(id1);		
		assertFalse(pickingPointsSystem.getPackageLockers().contains(packageLocker));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemovePackageLockerNotFound() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		int id1=5;
		
		pickingPointsSystem.removePackageLocker(id1);
	}
	
	@Test
	public void testListPackageLockerOn() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
			
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=15;
		GPSCoordinate gps2=new GPSCoordinate(79,134);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
				
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		packageLocker2.outOfService();
		
		int id3=52;
		GPSCoordinate gps3=new GPSCoordinate(43,86);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);
				
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		int numPackageLockersOn=2;
		
		assertNotNull(pickingPointsSystem.listPackageLockerOn());
		assertNotSame(pickingPointsSystem.listPackageLockerOn(),pickingPointsSystem);
		assertNotEquals(pickingPointsSystem.listPackageLockerOn(),pickingPointsSystem);
		assertEquals(pickingPointsSystem.listPackageLockerOn().size(),numPackageLockersOn);
	}
	
	@Test
	public void testListPackageLockerOff() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(21,15);
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		

		int id2=8;
		GPSCoordinate gps2=new GPSCoordinate(39,76);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
				
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		packageLocker2.outOfService();
		

		int id3=25;
		GPSCoordinate gps3=new GPSCoordinate(67,125);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);
		 
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		int numPackageLockersOff=1;
		
		assertNotNull(pickingPointsSystem.listPackageLockerOff());
		assertEquals(pickingPointsSystem.listPackageLockerOff().size(),numPackageLockersOff);
	}
	
	@Test
	public void testListPackageLockerRadio() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=8;
		GPSCoordinate gps2=new GPSCoordinate(39,76);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		int id3=19;
		GPSCoordinate gps3=new GPSCoordinate(70,110);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);

			
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		
		
		double radio=58.8;
		GPSCoordinate gps=new GPSCoordinate(54,73);
		List<PackageLocker> packageLockerRadio=pickingPointsSystem.listPackageLockerRadio(radio, gps);
		assertNotNull(packageLockerRadio);
		assertNotEquals(packageLockerRadio,pickingPointsSystem);
		assertNotSame(packageLockerRadio,pickingPointsSystem);
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testListPackageLockerNegativeRadio() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
				
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		double radio=-90;
		GPSCoordinate gps=new GPSCoordinate(45,132);
		
		@SuppressWarnings("unused")
		List<PackageLocker> packageLockerRadio=pickingPointsSystem.listPackageLockerRadio(radio, gps);
	}
	
	@Test(expected=NullPointerException.class)
	public void testListPackageLockerRadioGpsNull() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};				
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		double radio=90;
		GPSCoordinate gps=null;
		
		@SuppressWarnings("unused")
		List<PackageLocker> packageLockerRadio=pickingPointsSystem.listPackageLockerRadio(radio, gps);
	}
	
	@Test
	public void testGetNearestPackageLocker() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=8;
		GPSCoordinate gps2=new GPSCoordinate(39,76);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
				
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		int id3=19;
		GPSCoordinate gps3=new GPSCoordinate(60,124);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);
			
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		
		GPSCoordinate gps=new GPSCoordinate(40,73);
		PackageLocker nearestPackageLocker=pickingPointsSystem.getNearestPackageLocker(gps);
		assertNotNull(nearestPackageLocker);
		assertEquals(nearestPackageLocker,packageLocker2);
		assertNotSame(nearestPackageLocker,packageLocker2);
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetNearestPackageLockerGpsNull() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		GPSCoordinate gps=null;
		pickingPointsSystem.getNearestPackageLocker(gps);
	}
	
	@Test
	public void testListPackageLockerEmptyLocker() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=8;
		GPSCoordinate gps2=new GPSCoordinate(39,76);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		int id3=19;
		GPSCoordinate gps3=new GPSCoordinate(70,110);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);

			
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		
		int emptyLockers=3;
		
		List<PackageLocker> packageLockerEmptyLocker=pickingPointsSystem.listPackageLockerEmptyLocker();
		assertNotNull(packageLockerEmptyLocker);
		assertEquals(packageLockerEmptyLocker.size(),emptyLockers);
	}
	
	@Test
	public void testGetPackageLocker() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
			
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		int index=0;
		
		PackageLocker packageLocker2=pickingPointsSystem.getPackageLocker(index);
		assertEquals(packageLocker1,packageLocker2);
		assertNotSame(packageLocker1,packageLocker2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetPackageLockerNegativeIndex() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
			
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		int index=-2;
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker2=pickingPointsSystem.getPackageLocker(index);
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testGetPackageLockerBiggerIndex() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
			
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		int index=200;
		
		@SuppressWarnings("unused")
		PackageLocker packageLocker2=pickingPointsSystem.getPackageLocker(index);
	}
	
	@Test
	public void testGetSize() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};				
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		int size=1;
		
		assertEquals(size,pickingPointsSystem.getSize());
	}
	
	@Test
	public void testGetPackageLockers() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		
		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		
		int id2=15;
		GPSCoordinate gps2=new GPSCoordinate(78,10);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
					
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		
		int id3=45;
		GPSCoordinate gps3=new GPSCoordinate(65,100);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);
		
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		
		List<PackageLocker> newPackageLockers=pickingPointsSystem.getPackageLockers();
		
		assertNotNull(newPackageLockers);
		assertEquals(newPackageLockers,pickingPointsSystem.getPackageLockers());
		assertNotSame(newPackageLockers,pickingPointsSystem.getPackageLockers());
	}
	
	@Test
	public void testToString() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		

		int id2=15;
		GPSCoordinate gps2=new GPSCoordinate(78,10);
		LocalTime openingHour2=LocalTime.of(9,15);
		LocalTime closingHour2=LocalTime.of(20,15);
					
		
		PackageLocker packageLocker2=new PackageLocker(lockers,id2,gps2,openingHour2,closingHour2);
		

		int id3=45;
		GPSCoordinate gps3=new GPSCoordinate(65,100);
		LocalTime openingHour3=LocalTime.of(9,15);
		LocalTime closingHour3=LocalTime.of(20,15);
		
		
		PackageLocker packageLocker3=new PackageLocker(lockers,id3,gps3,openingHour3,closingHour3);
		
		
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem.addPackageLocker(packageLocker3);
		
		String infoLocker=pickingPointsSystem.toString();
		
		assertNotNull(infoLocker);
		assertNotEquals("",infoLocker);
	}
	
	@Test
	public void testEqualsTrue() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		PickingPointsSystem pickingPointsSystem2=new PickingPointsSystem(pickingPointsSystem);
		
		assertTrue(pickingPointsSystem.equals(pickingPointsSystem2));

	}
	
	@Test
	public void testEqualsFalse() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		PickingPointsSystem pickingPointsSystem2=new PickingPointsSystem();
		

		int id1=5;
		int id2=9;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		Locker lockers2[]= {locker2};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		PackageLocker packageLocker2=new PackageLocker(lockers2,id2,gps1,openingHour1,closingHour1);
		pickingPointsSystem2.addPackageLocker(packageLocker2);
		
		assertFalse(pickingPointsSystem.equals(pickingPointsSystem2));

	}
	
	@Test
	public void testEqualsFalseNotSameLength() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		PickingPointsSystem pickingPointsSystem2=new PickingPointsSystem();
		

		int id1=5;
		int id2=9;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		GPSCoordinate gps2=new GPSCoordinate(45,78);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
		Locker lockers2[]= {locker2};
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		PackageLocker packageLocker2=new PackageLocker(lockers2,id2,gps2,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		pickingPointsSystem.addPackageLocker(packageLocker2);
		pickingPointsSystem2.addPackageLocker(packageLocker1);
		
		assertFalse(pickingPointsSystem.equals(pickingPointsSystem2));

	}
	
	@Test
	public void testEqualsTrueSameObject() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		
		assertTrue(pickingPointsSystem.equals(pickingPointsSystem));

	}
	
	@Test
	public void testEqualsObjectNotPickingPointsSystem() {
		PickingPointsSystem pickingPointsSystem=new PickingPointsSystem();
		

		int id1=5;
		GPSCoordinate gps1=new GPSCoordinate(60,120);
		LocalTime openingHour1=LocalTime.of(9,15);
		LocalTime closingHour1=LocalTime.of(20,15);
		
		int numLocker2=3;
		Locker locker2=new Locker(numLocker2);
		int numLocker3=7;
		Locker locker3=new Locker(numLocker3);
		
		Locker lockers[]= {locker2,locker3};
			
		
		PackageLocker packageLocker1=new PackageLocker(lockers,id1,gps1,openingHour1,closingHour1);
		pickingPointsSystem.addPackageLocker(packageLocker1);
		
		assertFalse(pickingPointsSystem.equals(packageLocker1));

	}
	
}
