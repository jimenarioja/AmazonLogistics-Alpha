/**
 * La clase PickingPointsSystem representa un conjunto de PackageLocker (puntos de recogida).
 * 
 * @author jimenarioja
 */


package uva.poo.entrega1;
import java.util.ArrayList;
import java.util.List;
import es.uva.inf.poo.maps.GPSCoordinate;


public class PickingPointsSystem {
	
	private List<PackageLocker> packageLockers;
	 
	/**
	 * Constructor de PickingPointsSystem por defecto
	 */
	public PickingPointsSystem() {  
		packageLockers=new ArrayList<>();
	}
	 
	/**
	 * Constructor copia de PickingPointSystem
	 * @param pickingPointsSystem
	 * @throws NullPointerException si pickingPointsSystem es null
	 */
	public PickingPointsSystem(PickingPointsSystem pickingPointsSystem) {
		if(pickingPointsSystem==null) {
			throw new NullPointerException("PickingPointsSystem no puede ser null");
		}
		this.packageLockers = new ArrayList<>();
		List<PackageLocker> pl = pickingPointsSystem.getPackageLockers();
		for(int index=0;index<pl.size();index++) {
			this.packageLockers.add(new PackageLocker(pl.get(index)));
		}
	}
	
	/**
	 * Constructor de PickingPointSystem
	 * @param packageLockers, lista de PackageLocker
	 */
	public PickingPointsSystem(List<PackageLocker> packageLockers) {
		setPackageLocker(packageLockers);
	}
	
	/**
	 * Modifica la lista de PackageLockers
	 * @param packageLockers, lista de PackageLocker
	 */
	public void setPackageLocker(List<PackageLocker> packageLockers) { 
		this.packageLockers = new ArrayList<>();
		for(int index=0;index<packageLockers.size();index++) {
			this.packageLockers.add(new PackageLocker(packageLockers.get(index)));
		}
	}
	
	/** 
	 * Añade un nuevo package locker
	 * @param packageLocker1
	 * @throws NullPointerException si packageLocker1 es null
	 * @throws IllegalArgumentException si el punto ya está en la lista
	 * @throws IllegalArgumentException si esa coordenada ya está en la lista
	 */
	public void addPackageLocker(PackageLocker packageLocker) {
		if(packageLocker==null) {
			throw new NullPointerException("El packageLocker es null");
		}
		if(packageLockers.contains(packageLocker)) {
			throw new IllegalArgumentException("El punto de recogida ya está");
		}
		for(int index=0;index<getSize();index++) {
			if(packageLocker.getGps().equals(getPackageLocker(index).getGps())) {
				throw new IllegalArgumentException("Ya hay un packageLocker en esa localización");
			}
		}
		packageLockers.add(new PackageLocker(packageLocker));
	}
	
	/**
	 * Elimina un package locker a partir de su id
	 * @param id, int, el id del packageLocker a eliminar
	 * @throws IllegalArgumentException si el package locker no se encuentra en la lista
	 */
	public void removePackageLocker(int id) {
		boolean found=false;
		for(int index=0;!found && index<packageLockers.size();index++) {
			if(packageLockers.get(index).getId()==id) {
				packageLockers.remove(index);
				found=true;
			}
		}
		if(!found) {
			throw new IllegalArgumentException("No existe el package locker");
		}
	}
	
	/**
	 * Lista los packageLockers operativos
	 * @return list de PackageLocker operativos
	 */
	public List<PackageLocker> listPackageLockerOn(){
		List<PackageLocker> packageLockerOn=new ArrayList<>();
		for(int index=0;index<packageLockers.size();index++) {
			if(!packageLockers.get(index).isOutOfService()) {
				packageLockerOn.add(new PackageLocker(packageLockers.get(index)));
			}
		} 
		
		return packageLockerOn;
	}
	
	/**
	 * Lista los packageLockers fuera de servicio
	 * @return list de PackageLocker fuera de servicio
	 */
	public List<PackageLocker> listPackageLockerOff(){
		List<PackageLocker> packageLockerOff=new ArrayList<>();
		
		for(int index=0;index<packageLockers.size();index++) {
			if(packageLockers.get(index).isOutOfService()) {
				packageLockerOff.add(new PackageLocker(packageLockers.get(index)));
			}
		}
		
		return packageLockerOff;
	}

	/**
	 * Lista los packageLockers en un radio dado a partir de un packageLocker
	 * @param radio, double, el radio
	 * @param packageLocker1, packageLocker centro de búsqueda
	 * @return list de packageLocker que se encuentran en dicho rango
	 * @throws IllegalArgumentException si el radio de búsqueda es negativo
	 * @throws NullPointerException si gps es null
	 */
	public List<PackageLocker> listPackageLockerRadio(double radio, GPSCoordinate gps){
		if(radio<0) { 
			throw new IllegalArgumentException("El radio de búsqueda no puede ser negativo");
		}
		if(gps==null) {
			throw new NullPointerException("Las coordenadas no pueden ser null");
		}
		
		List<PackageLocker> packageLockerRadio=new ArrayList<>();
		
		for(int index=0;index<packageLockers.size();index++) {
			if((gps.getDistanceTo(packageLockers.get(index).getGps()))<=radio) {
				packageLockerRadio.add(new PackageLocker(packageLockers.get(index)));
			}
		}
		return packageLockerRadio;
	}

	/**
	 * Consulta el packageLocker más cercano dadas unas coordenadas
	 * @param gps, GPSCoordinate
	 * @return packageLocker, el packageLocker más cercano a gps
	 * @throws NullPointerException, si gps es null
	 * @throws IllegalArgumentException si no hay ningún packageLocker en la lista
	 */
	public PackageLocker getNearestPackageLocker(GPSCoordinate gps) {
		if(gps==null) {
			throw new NullPointerException("Las coordenadas no pueden ser null");
		}
		
		PackageLocker packageLocker=null;
		for(int index=0;index<packageLockers.size();index++) {
			if(packageLocker == null || (packageLocker.getGps().getDistanceTo(gps)>getPackageLocker(index).getGps().getDistanceTo(gps))) {
				packageLocker=new PackageLocker(getPackageLocker(index));
			}
		}
		
		return packageLocker;
	}
	
	/**
	 * Lista los packagelockers con alguna taquilla vacía
	 * @return list de packageLocker que tienen alguna taquilla vacía
	 */
	public List<PackageLocker> listPackageLockerEmptyLocker(){
		List<PackageLocker> packageLockerEmpty=new ArrayList<>();
		
		for(int index=0;index<packageLockers.size();index++) {
			if(!packageLockers.get(index).isFull()) {
				packageLockerEmpty.add(new PackageLocker(packageLockers.get(index)));
			}
		} 
		
		return packageLockerEmpty;
	} 
	
	/**
	 * Consulta el packageLocker según su índice
	 * @return packageLocker
	 */
	public PackageLocker getPackageLocker(int index) {
		if(index<0) {
			throw new IllegalArgumentException("El índice no puede ser negativo");
		}
		if(index>=packageLockers.size()) {
			throw new IllegalArgumentException("El índice es superior al tamaño de la lista");
		}
		
		return new PackageLocker(packageLockers.get(index));
	}
	
	/**
	 * Consulta la longitud de pickingpointsystem
	 * @return int (entero mayor o igual que cero)
	 */
	public int getSize() {
		return packageLockers.size();
	}
	
	/**
	 * Devuelve toda la lista de packageLockers
	 * @return list<PackageLocker>
	 */
	public List<PackageLocker> getPackageLockers(){ 
		List<PackageLocker> packageLockersCopy=new ArrayList<>();
		for(int index=0;index<packageLockers.size();index++) {
			packageLockersCopy.add(packageLockers.get(index));
		}
		return packageLockersCopy;
	}
	
	@Override
	public String toString() {
		String s="";
		
		for(int index=0;index<packageLockers.size();index++) {
			s+="\n"+packageLockers.get(index);
		}
		
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		
		if(! (o instanceof PickingPointsSystem)) {
			return false;
		}
		
		PickingPointsSystem pickingPointsSystem=(PickingPointsSystem) o;
		
		if(pickingPointsSystem.getSize()!=getSize()) {
			return false;
		}
		
		for( PackageLocker p : getPackageLockers()) {
			if( !pickingPointsSystem.getPackageLockers().contains(p)) {
				return false;
			}
		}
		
		return true;
	}
	
}
