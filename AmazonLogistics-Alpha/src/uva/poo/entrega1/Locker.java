/**
 * La clase Locker representa una taquilla con dimensiones con la capacidad de almacenar un
 *  paquete
 * 
 * @author jimrioja
 */

package uva.poo.entrega1;

public class Locker {

	private Package storedPackage;
	private int numLocker;
	private double width;
	private double length;
	private double height;
	
	/**
	 * Constructor de taquilla sabiendo su n�mero
	 * @param numLocker, int, n�mero de taquilla
	 * @throws IllegalArgumentException si numLocker es negativo
	 */
	public Locker(int numLocker) {
		storedPackage=null;
		setNumLocker(numLocker);
		width=50;
		length=50;
		height=50;
	}
	
	/**
	 * Constructor de taquilla sabiendo su n�mero y el paquete que va a almacenar
	 * @param numLocker, int, n�mero de taquilla
	 * @param storedPackage, Package, paquete a almacenar
	 * @throws IllegalArgumentException si numLocker es negativo
	 */
	public Locker(int numLocker, Package storedPackage) {
		setStoredPackage(storedPackage);
		setNumLocker(numLocker);
		width=storedPackage.getWidth()+10;
		length=storedPackage.getLength()+10;
		height=storedPackage.getHeight()+10;
	}
	
	/**
	 * Constructor de taquilla
	 * @param storedPackage, Package en su interior
	 * @param numLocker, int, n�mero de taquilla
	 * @param width, double, ancho de taquilla
	 * @param length, double, largo de taquilla
	 * @param height, double, alto de taquilla
	 * @throws IllegalArgumentException si numLocker es negativo
	 * @throws IllegalArgumentException si width no es positivo
	 * @throws IllegalArgumentException si length no es positivo
	 * @throws IllegalArgumentException si height no es positivo
	 */
	public Locker(Package storedPackage, int numLocker,double width, 
			double length, double height) {
		
		if(storedPackage != null) {
			setStoredPackage(storedPackage);
		}
		setNumLocker(numLocker);
		setWidth(width);
		setLength(length);
		setHeight(height);
	}
	
	/**
	 * Constructor de taquilla
	 * @param numLocker, int, n�mero de taquilla
	 * @param width, double, ancho de taquilla
	 * @param length, double, largo de taquilla
	 * @param height, double, alto de taquilla
	 * @throws IllegalArgumentException si numLocker es negativo
	 * @throws IllegalArgumentException si width no es positivo
	 * @throws IllegalArgumentException si length no es positivo
	 * @throws IllegalArgumentException si height no es positivo
	 */
	public Locker(int numLocker,double width, 
			double length, double height) {
		
		setNumLocker(numLocker);
		setWidth(width);
		setLength(length);
		setHeight(height);
	}
	
	/**
	 * Constructor copia de taquilla
	 * @param locker, taquilla a copiar
	 * @throws IllegalArgumentException si numLocker es negativo
	 * @throws IllegalArgumentException si width no es positivo
	 * @throws IllegalArgumentException si length no es positivo
	 * @throws IllegalArgumentException si height no es positivo
	 */
	public Locker(Locker locker) {
		this(locker.getStoredPackage(),locker.getNumLocker(),locker.getWidth(),
				locker.getLength(),locker.getHeight());
	}
	
	/**
	 * Modifica el paquete del interior de la taquilla
	 * @param storedPackage, Package
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentExcpetion si el paquete ya ha sido devuelto
	 */
	public void setStoredPackage(Package storedPackage) {
		if(storedPackage == null) {
			throw new NullPointerException("El paquete no puede ser null");
		}
		if(storedPackage.getPickUpStatus()){ 
			throw new IllegalArgumentException("El paquete que se quiere guardar ya ha sido recogido");
		}
		if(storedPackage.getReturnStatus()) {
			throw new IllegalArgumentException("El paquete que se quiere guardar ya ha sido devuelto");
		}
		this.storedPackage=new Package(storedPackage);
	}
	
	/**
	 * Modifica el n�mero de taquilla
	 * @param numLocker, int, n�mero de taquilla
	 * @throws IllegalArgumentException si numLocker es negativo
	 */
	public void setNumLocker(int numLocker) {
		if(numLocker<0) {
			throw new IllegalArgumentException("El n�mero de taquilla no puede ser negativo");
		}
		this.numLocker=numLocker;
	}
	
	/**
	 * Modifica el ancho de taquilla
	 * @param width, double, ancho de taquilla
	 * @throws IllegalArgumentException si width no es positivo
	 */
	public void setWidth(double width) {
		if(width<=0) {
			throw new IllegalArgumentException("El ancho de la taquilla ha de ser positivo");
		}
		this.width=width;
	}
	
	/**
	 * Modifica el largo de taquilla
	 * @param length, double, largo de taquilla
	 * @throws IllegalArgumentException si length no es positivo
	 */
	public void setLength(double length) {
		if(length<=0) {
			throw new IllegalArgumentException("El largo de la taquilla ha de ser positivo");
		}
		this.length=length;		
	}
	
	/**
	 * Modifica el alto de taquilla
	 * @param height, double, alto de taquilla
	 * @throws IllegalArgumentException si height no es positivo
	 */
	public void setHeight(double height) {
		if(height<=0) {
			throw new IllegalArgumentException("El alto de la taquilla ha de ser positivo");
		}
		this.height=height;
	}
	
	/**
	 * Consulta el paquete que se encuentra en el interior de la taquilla
	 * @return storedPackage, Package
	 */
	public Package getStoredPackage() {
		if(storedPackage == null) {
			return null;
		}
		return new Package(storedPackage);
	}
	
	/**
	 * Consulta el n�mero de taquilla
	 * @return numLocker, int
	 */
	public int getNumLocker() {
		return numLocker;
	}
	
	/**
	 * Consulta el ancho de taquilla
	 * @return width, double positivo
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Consulta el largo de taquilla
	 * @return length, double positivo
	 */
	public double getLength() {
		return length;
	}
	
	/**
	 * Consulta el alto de taquilla
	 * @return height, double positivo
	 */
	public double getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		String s="";
		
		s+="Package: "+getStoredPackage();
		s+="Number of locker: "+getNumLocker();
		s+="Width: "+getWidth();
		s+="Length: "+getLength();
		s+="Height: "+getHeight();
		
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if( !(o instanceof Locker) ) {
			return false;
		}
		Locker locker = (Locker)o;
		return numLocker==locker.getNumLocker();
	}
	
}
