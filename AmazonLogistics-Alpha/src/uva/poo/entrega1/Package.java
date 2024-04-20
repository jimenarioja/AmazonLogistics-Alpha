/**
 * La clase Package representa un paquete con dimensiones y con una fecha límite de recogida. 
 * El paquete también tiene un estado de recogida por el usuario y un estado sobre su 
 * devolución a central. 
 *  
 * @author jimenarioja
 */

package uva.poo.entrega1;

import java.time.LocalDate;

public class Package {

	private String id;
	private LocalDate expirationDate;
	private boolean pickUpStatus;
	private boolean returnStatus;
	private double width;
	private double length;
	private double height;
	
	 
	/**
	 * Constructor de Package
	 * @param id, string, identificador del paquete
	 * @param expirationDate, localDate, fecha límite de recogida del paquete
	 * @param pickUpStatus, boolean, estado de recogida (true recogido, false en caso contrario)
	 * @param returnStatus, boolean, estado de devolución (true devuelto, false en caso contrario)
	 * @throws NullPointerException si el id es null
	 * @throws IllegalArgumentException si el décimo dígito no es el resto de la división entera entre 10.
	 * @throws IllegalArgumentException si el id no tiene 10 dígitos.
	 * @throws IllegalArgumentException si el id contiene algún caracter que no sea dígito
	 * @throws NullPointerException si expirationDate es null
	 */
	public Package(String id, LocalDate expirationDate, double width, double length, double height) {
		setId(id);
		setExpirationDate(expirationDate);
		notPickUpPackage();
		notReturnPackage();
		setWidth(width);
		setLength(length);
		setHeight(height);
	}
	
	/**
	 * Constructor copia de Package
	 * @param packageCopy
	 * @throws NullPointerException si el id es null
	 * @throws IllegalArgumentException si el décimo dígito no es el resto de la división entera entre 10.
	 * @throws IllegalArgumentException si el id no tiene 10 dígitos.
	 * @throws IllegalArgumentException si el id contiene algún caracter que no sea dígito
	 * @throws NullPointerException si expirationDate es null
	 */
	public Package(Package packageCopy) {
		this(packageCopy.getId(),packageCopy.getExpirationDate(),packageCopy.getWidth(),packageCopy.getLength(),packageCopy.getHeight());
	}
	
	/**
	 * Modifica el valor del id del package
	 * @param id, cualquier string
	 * @throws NullPointerException si el id es null
	 * @throws IllegalArgumentException si el décimo dígito no es el resto de la división entera entre 10.
	 * @throws IllegalArgumentException si el id no tiene 10 dígitos.
	 * @throws IllegalArgumentException si el id contiene algún caracter que no sea dígito
	 */
	public void setId(String id) {
		if(id==null) {
			throw new NullPointerException("El id no puede ser null");
		}
		if(id.length()==10) {
			int addition=0;
			int i=0;
			while(i<id.length()-1 && id.charAt(i)>='0' && id.charAt(i)<='9') {
				addition+=id.charAt(i)-'0';
				i++;
			}
			if(i!=id.length()-1) {
				throw new IllegalArgumentException("Todos los caracteres han de ser digitos");
			}
			if(addition%10!=id.charAt(id.length()-1)-'0') {
				throw new IllegalArgumentException("El décimo dígito tiene que ser el modulo de la división entera de 10.");
			}
			this.id=id;
		}
		else {
			throw new IllegalArgumentException("El id no tiene 10 dígitos");
		}
	}
	
	/**
	 * Modifica la fecha final del paquete
	 * @param finalDate, cualquier fecha
	 * @throws NullPointerException si expirationDate es null
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		if(expirationDate==null) {
			throw new NullPointerException("La fecha no puede ser null");
		}
		this.expirationDate = LocalDate.of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
	}

	/**
	 * Modifica el ancho del paquete
	 * @param width, double, ancho del paquete
	 * @throws IllegalArgumentException si no es positivo
	 */
	public void setWidth(double width) {
		if(width<=0) {
			throw new IllegalArgumentException("Ancho del paquete no válido");
		}
		this.width=width;
	}
	
	/**
	 * Modifica el largo del paquete
	 * @param length, double, largo del paquete
	 * @throws IllegalArgumentException si no es positivo
	 */
	public void setLength(double length) {
		if(length<=0) {
			throw new IllegalArgumentException("Ancho del paquete no válido");
		}
		this.length=length;
	}
	
	/**
	 * Modifica el alto del paquete
	 * @param height, double, alto del paquete
	 * @throws IllegalArgumentException si no es positivo
	 */
	public void setHeight(double height) {
		if(height<=0) {
			throw new IllegalArgumentException("Ancho del paquete no válido");
		}
		this.height=height;
	}
	
	/**
	 * Consulta el valor del id
	 * @return id, string
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Consulta la fecha límite
	 * @return finalDate, una fecha LocalDate
	 */
	public LocalDate getExpirationDate() {
		return LocalDate.of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
	}
	
	/**
	 * Consulta si el paquete ha sido recogido o no
	 * @return boolean, (true si ha sido recogido, false en caso contrario)
	 */
	public boolean getPickUpStatus() {
		return pickUpStatus;
	}
	
	/**
	 * Consulta si el paquete ha sido devuelto o no
	 * @return boolean, (true si ha sido devuelto, false en caso contrario)
	 */
	public boolean getReturnStatus() {
		return returnStatus;
	}
	
	/**
	 * Consulta el ancho del paquete
	 * @return width, double, ancho del paquete
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Consulta el largo del paquete
	 * @return length, double, largo del paquete
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Consulta el alto del paquete
	 * @return height, double, alto del paquete
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Comprueba si la fecha dada es más tarde que la de fin de almacenaje
	 * @param date, LocalDate
	 * @return boolean, (true si date es antes que la fecha final, false en otro caso)
	 * @throws NullPointerException si date es null
	 */
	public boolean outOfTime(LocalDate date) {
		if(date==null) {
			throw new NullPointerException("La fecha no puede ser null");
		}
		return getExpirationDate().isBefore(date);
	}
	
	/**
	 * Cambia el estado del paquete a recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 */
	public void pickUpPackage() {
		if(getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ha sido devuelto");
		}
		pickUpStatus=true;
	}
	
	/**
	 * Cambia el estado del paquete a no recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 */
	public void notPickUpPackage() {
		if(getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ha sido devuelto");
		}
		pickUpStatus=false;
	}
	
	/**
	 * Cambia el estado del paquete a devuelto
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 */
	public void returnPackage() {
		if(getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido devuelto");
		}
		returnStatus=true;
	}
	
	
	/**
	 * Cambia el estado del paquete a no devuelto
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 */
	public void notReturnPackage() {
		if(getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido");
		}
		if(getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido devuelto");
		}
		returnStatus=false;		
	}
	
	/**
	 * Aplaza la fecha límite de recogida una cantidad de días
	 * @param increaseOfDays, int, número de días de incremento en la fecha de recogida
	 * @throws IllegalArgumentException si el paquete ya ha sido recogido
	 * @throws IllegalArgumentException si el paquete ya ha sido devuelto
	 */
	public void delayPickUpDay(int increaseOfDays) {
		if(getPickUpStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido recogido.");
		}
		if(getReturnStatus()) {
			throw new IllegalArgumentException("El paquete ya ha sido devuelto.");
		}
		setExpirationDate(getExpirationDate().plusDays(increaseOfDays));
	}
	
	@Override
	public String toString() {
		String s="";
		
		s+="Id: "+getId();
		s+="\nExpiration date: "+getExpirationDate();
		s+="\nPick up status: "+getPickUpStatus();
		s+="\nReturn status: "+getReturnStatus();
		
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if( !(o instanceof Package) ) {
			return false;
		}
		Package p = (Package)o;
		return id.equals(p.getId());
	}
}