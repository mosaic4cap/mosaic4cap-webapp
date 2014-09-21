package de.mosaic4cap.webapp.stereotypes.annotation;

import org.springframework.stereotype.Repository;

/**
 * Annotation to identify Data Access Objects
 * normally its provided by Springs @Repository Annotation
 * but this can be missunderstood, so @Dao will implements
 * @Repository capabilities cause its iterally the same but
 * its more clear
 *
 * Created by Lobedan on 30.08.2014.
 */
@Repository
public @interface Dao {
}

