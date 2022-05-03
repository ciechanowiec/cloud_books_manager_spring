package eu.ciechanowiec.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Herman Ciechanowiec
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {

    ResourceNotFoundException(String resourceName, String resourceId) {
        super(String.format("The requested resource [%s] "
                            + "with ID [%s] hasn't been found.",
                            resourceName, resourceId));
    }
}
