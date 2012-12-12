/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.webforms;

import java.io.Serializable;

import org.springframework.validation.BindingResult;

/**
 * @author iandonescu
 *
 */
public abstract class AbstractForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void additionalVerification(BindingResult bindingResult);
}
