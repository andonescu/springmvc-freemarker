/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.webforms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author iandonescu
 * 
 */
public class TaskForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	@NotNull
	private BigDecimal workedHours;
	@NotNull
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date startDate;
	@NotNull
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date endDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(BigDecimal workedHours) {
		this.workedHours = workedHours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskForm [title=").append(title)
				.append(", description=").append(description)
				.append(", workedHours=").append(workedHours)
				.append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append("]");
		return builder.toString();
	}

}
