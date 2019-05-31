package io.javabrains.moviecatalogservice.models;

import java.io.Serializable;

public interface HasId extends Serializable {

	/** Gets the Id of entity
	 * @return
	 */
	Long getId();
}
