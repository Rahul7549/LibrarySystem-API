package com.library.service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.service.model.*;

public interface BooksRepository extends JpaRepository<Books,Long> {

}
