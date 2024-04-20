/**
 * La clase PackageLocker representa un punto de recogida en el espacio en el que se encuentran 
 * un conjunto de taquillas las cuales pueden contener un paquete. En PackageLocker se puede
 * recoger el paquete. 
 * 
 * @author jimenarioja
 */

package uva.poo.entrega1;

import es.uva.inf.poo.maps.GPSCoordinate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PackageLocker {

	private int id;
	private GPSCoordinate gps;
	private LocalTime openingHour;
	private LocalTime closingHour;
	private boolean statusOutOfService;
	private Locker lockers[];
	
	/**
	 * Constructor de PackageLocker con todos los atributos
	 * @param size, int, número de taquillas
	 * @param id, int, id de PackageLocker
	 * @param gps, GPSCoordinate, coordenadas GPS de PackageLocker
	 * @param openingHour, LocalTime, horario de apertura de PackageLocker
	 * @param closingHour, LocalTime, horario de cierre de PackageLocker
	 * @param statusOutOfService, boolean, si PackageLocker está fuera de servicio o no
	 * @throws NullPointerException si gps es null
	 * @throws NullPointerException si openingHour es null
	 * @throws NullPointerException si closingHour es null
	 * @throws IllegalArgumentException si el horario de apertura es igual o más tarde que el de cierre
	 */
	public PackageLocker(Locker lockers[], int id, GPSCoordinate gps, LocalTime openingHour,
			LocalTime closingHour) {
		this.lockers = new Locker[lockers.length]; 
		for(int i=0;i<lockers.length;i++) {
			this.lockers[i]=new Locker(lockers[i]);
		}
		
		setId(id);
		setGps(gps);
		setOpeningHour(openingHour);
		setClosingHour(closingHour); 
		notOutOfService();
	}
	 
	/**
	 * Constructor copia de PackageLocker
	 * @param packageLocker, PackageLocker
	 * @throws NullPointerException si packageLocker es null
	 */
	public PackageLocker(PackageLocker packageLocker) {
		this(packageLocker.getLockers(),packageLocker.getId(),packageLocker.getGps(), 
				packageLocker.getOpeningHour(), packageLocker.getClosingHour());
		
		if(packageLocker.isOutOfService()) {
			outOfService();
		}
	}
	
	/**
	 * Modifica el id
	 * @param id, string
	 * @throws IllegalArgumentException si el id es negativo
	 */
	public void setId(int id) {
		if(id<0) {
			throw new IllegalArgumentException("El id no puede ser negativo");
		}
		this.id=id;
	}
	
	/**
	 * Modifica las coordenadas gps
	 * @param gps, GPSCoordinate
	 * @throws NullPointerException si gps es null
	 */
	public void setGps(GPSCoordinate gps) {
		if(gps==null) {
			throw new NullPointerException("Las coordenadas no pueden ser null");
		}
		this.gps=new GPSCoordinate(gps.getLatitudeGD(),gps.getLongitudeGD());
	}
	
	/**
	 * Modifica la hora de apertura
	 * @param openingHour, LocalTime
	 * @throws NullPointerException si el horario de apertura es null
	 * @throws IllegalArgumentException si el horario de apertura es igual o más tarde que el de cierre
	 */
	public void setOpeningHour(LocalTime openingHour) {
		if(openingHour==null) {
			throw new NullPointerException("El horario de apertura no puede ser null");
		}
		if(getClosingHour()!=null && !openingHour.isBefore(getClosingHour())) {
			throw new IllegalArgumentException("El horario de apertura no puede ser despues que el de cierre");
		}
		this.openingHour=LocalTime.of(openingHour.getHour(), openingHour.getMinute());
	}
	
	/**
	 * Modifica la hora de cierre
	 * @param closingHour, LocalTime
	 * @throws NullPointerException si closingHour es null
	 * @throws IllegalArgumentException si closingHour es igual o antes que openingHour
	 */
	public void setClosingHour(LocalTime closingHour) {
		if(closingHour==null) {
			throw new NullPointerException("El horario de cierre no puede ser null");
		}
		if(!closingHour.isAfter(getOpeningHour())) {
			throw new IllegalArgumentException("El horario de cierre no puede ser antes que el de apertura.");
		}
		this.closingHour=LocalTime.of(closingHour.getHour(), closingHour.getMinute());
	}
	
	/**
	 * Modifica el estado a fuera de servicio
	 */
	public void outOfService() {
		this.statusOutOfService=true;
	}
	
	/**
	 * Modifica el estado a operativo
	 */
	public void notOutOfService() {
		this.statusOutOfService=false;
	}
	
	/**
	 * Consulta el id
	 * @return id, int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Consulta las coordenadas gps
	 * @return gps, GPSCoordinate
	 */
	public GPSCoordinate getGps() {
		return new GPSCoordinate(gps.getLatitudeGD(),gps.getLongitudeGD());
	}
	
	/**
	 * Consulta el horario de apertura
	 * @return openingHour, LocalTime
	 */
	public LocalTime getOpeningHour() {
		if(openingHour==null) {
			return null;
		}
		return LocalTime.of(openingHour.getHour(), openingHour.getMinute());
	}

	/**
	 * Consulta el horario de cierre
	 * @return closingHour, LocalTime
	 */
	public LocalTime getClosingHour() {
		if(closingHour==null) {
			return null;
		}
		return LocalTime.of(closingHour.getHour(), closingHour.getMinute());
	}
	
	/**
	 * Consulta el status
	 * @return boolean (false si está operativo, true en caso contrario)
	 */
	public boolean isOutOfService() {
		return statusOutOfService;
	}
	
	/**
	 * Consulta el número de lockers
	 * @return int, número de lockers (siempre mayor o igual que cero)
	 */
	public int getNumLockers() {
		return lockers.length;
	}
	
	/**
	 * Consulta el número de lockers vacíos
	 * @return int, número de Lockers vacíos (siempre mayor o igual que cero)
	 */
	public int getNumEmptyLockers() {
		int numEmptyLockers=0;
		
		for(int i=0;i<lockers.length;i++) {
			if(lockers[i].getStoredPackage()==null) {
				numEmptyLockers++;
			}
		}
		
		return numEmptyLockers;
	}
	
	/**
	 * Consulta el número de lockers en los que hay un paquete
	 * @return int, el número de lockers llenos, (que es siempre mayor o igual que 0)
	 */
	public int getNumFullLockers() {
		return lockers.length-getNumEmptyLockers();
	}
	
	/**
	 * Consulta el número de taquilla en la que está un paquete a partir de su id
	 * @param id, string, que es el id del paquete
	 * @return int, posición del locker que almacena el paquete buscado
	 * @throws NullPointerException si el id es null
	 * @throws IllegalArgumentException si no encuentra ningún package con ese id
	 */
	public int getLocker(String id) {
		if(id==null) {
			throw new NullPointerException("El id no puede ser null");
		}
		for(int i=0;i<lockers.length;i++) {
			if(lockers[i]!=null && lockers[i].getStoredPackage().getId().equals(id)) {
				return i;
			}
		}
		throw new IllegalArgumentException("No hay ningún paquete que tenga el id indicado");
	}
	
	/**
	 * Guarda el paquete en el primer locker que esté vacío
	 * @param package1, package a guardar
	 * @throws NullPointerException si package1 es null
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 * @throws IllegalArgumentException si no hay taquillas libres
	 */
	public void setPackage(Package package1) {
		if(package1==null) { 
			throw new NullPointerException("El paquete no puede ser null");
		}
		if(package1.getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(package1.getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido devuelto");
		}
		int index=0;
		while(index<lockers.length && lockers[index].getStoredPackage()!=null && (lockers[index].getWidth()>=package1.getWidth() &&
				lockers[index].getLength()>=package1.getLength() &&
				lockers[index].getHeight()>=package1.getHeight())) {
			index++;
		}
		if(index<lockers.length) {
			lockers[index].setStoredPackage(package1);
		}
		else {
			throw new IllegalArgumentException("No hay ninguna taquilla vacía.");
		}
	
	}
	
	/**
	 * El cliente saca el paquete de su taquilla 
	 * @param p, paquete a eliminar
	 * @throws NullPointerException si el id del paquete es null
	 * @throws NullPointerException si pickUpDate es null
	 * @throws NullPointerException si pickUpHour es null
	 * @throws IllegalArgumentException si no encuentra ningún package con ese id
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ha sido devuelto
	 * @throws IllegalArgumentException si ha expirado la fecha de recogida
	 * @throws IllegalArgumentException si la hora de recogida es antes que la hora de apertura
	 * @throws IllegalArgumentException si la hora de recogida es después que la de cierre
	 */
	public Package takeOutPackageAsCustomer(String id, LocalDate pickUpDate, LocalTime pickUpHour) {
		if(id==null) {
			throw new NullPointerException("El id del paquete no puede ser null.");
		}
		if(pickUpDate==null) {
			throw new NullPointerException("El día de recogida del paquete no puede ser null.");
		}
		if(pickUpHour==null) {
			throw new NullPointerException("La hora de recogida del paquete no puede ser null.");
		}
		if(pickUpHour.isBefore(getOpeningHour())) {
			throw new IllegalArgumentException("La hora de recogida no puede ser antes que la hora de apertura");
		}
		if(pickUpHour.isAfter(getClosingHour())) {
			throw new IllegalArgumentException("La hora de recogida no puede ser después que la hora de cierre");
		}
		
		Package package1=lockers[getLocker(id)].getStoredPackage();
		
		if(package1==null) {
			throw new NullPointerException("El paquete no puede ser null");
		}
		if(package1.getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(package1.getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ha sido devuelto");
		}
		if(package1.getExpirationDate().isBefore(pickUpDate)) {
			throw new IllegalArgumentException("Ha expirado la fecha para recoger el paquete");
		}
		
		package1.pickUpPackage();
		lockers[getLocker(package1.getId())]=null;
		return package1;
	}
	
	/**
	 * Saca el paquete de su taquilla y lo devuelve a la central
	 * @param p, paquete a eliminar
	 * @throws NullPointerException si package1 es null
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si no encuentra el paquete
	 */
	public void takeOutPackageToReturn(Package package1) {
		if(package1==null) {
			throw new NullPointerException("El paquete no puede ser nulo.");
		}
		if(package1.getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido devuelto.");
		}
		if(package1.getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido.");
		}
		
		package1.returnPackage();
		lockers[getLocker(package1.getId())]=null;
	}
	
	/**
	 * Consulta todas las taquillas
	 * @return lockersCopy, Locker[], array de taquillas
	 */
	public Locker[] getLockers() {
		Locker lockersCopy[]=new Locker[lockers.length];
		for(int index=0;index<lockers.length;index++) {
			lockersCopy[index]=lockers[index];
		}
		return lockersCopy;
	}
	
	/**
	 * Obtiene el paquete dado el número de taquilla
	 * @param numLocker, int, número de taquilla
	 * @return Package
	 * @throws IllegalArgumentException si el número de taquilla es negativo
	 * @throws IllegalArgumentException si el número de taquilla no es menor que el número máximo de taquillas
	 */
	public Package getPackage(int numLocker) {
		if(numLocker<0) {
			throw new IllegalArgumentException("El número de taquilla ha de ser positivo.");
		}
		if(numLocker>=getLockers().length) {
			throw new IllegalArgumentException("El número de taquilla ha de ser menor que el número máximo de taquillas existentes.");
		}
		return new Package(getLockers()[numLocker].getStoredPackage()); 
	}
	
	/**
	 * Crea un nuevo número de taquilla
	 * @return newNumLocker, int (siempre positivo)
	 */
	public int getNewNumberOfLocker() {
		int newNumLocker=0;
		for(int index=0;index<lockers.length;index++) {
			newNumLocker+=lockers[index].getNumLocker()+1;
		}
		return newNumLocker;
	}
	
	
	/**
	 * Añade más taquillas al packageLocker
	 * @param plusLockers, int, incremento de taquillas
	 */
	public void expandLockers(int plusLockers) {
		Locker auxLockers[]=this.lockers;
		this.lockers=new Locker[getNumLockers()+plusLockers];
		for(int i=0;i<auxLockers.length;i++) {
			lockers[i]=auxLockers[i];
		}
	}
	
	/**
	 * Consulta si el packageLocker está completo
	 * @return boolean (true si está lleno, false en caso contrario)
	 */
	public boolean isFull() {
		return getNumLockers()==getNumFullLockers();
	}
	
	@Override
	public String toString() {
		String s="";
		
		s+="Number of lockers: "+getNumLockers();
		s+="Identifier: "+getId();
		s+="Gps: "+getGps();
		s+="Opening hour: "+getOpeningHour();
		s+="Closing hour: "+getClosingHour();
		s+="Status out of service: "+isOutOfService();
		
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		} 
		if(! (o instanceof PackageLocker)) {
			return false;
		}
		PackageLocker packageLocker=(PackageLocker)o;
		return getId()==packageLocker.getId(); 
	}
	

}
