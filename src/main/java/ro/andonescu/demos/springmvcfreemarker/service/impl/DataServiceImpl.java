/**
 * 
 */
package ro.andonescu.demos.springmvcfreemarker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.andonescu.demos.springmvcfreemarker.service.DataService;
import com.google.common.collect.ImmutableList;

/**
 * @author iandonescu
 *
 */
@Service
public class DataServiceImpl implements DataService {

	/* (non-Javadoc)
	 * @see DataService#getCounties()
	 */
	public List<String> getCounties() {
		return ImmutableList.of("Iasi", "Neamt", "Bucuresti");
	}
}
