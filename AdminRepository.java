package com.capstone.FeedbackManagementSystem;
  
  import org.springframework.data.repository.reactive.ReactiveCrudRepository;
  import org.springframework.stereotype.Repository; import
  org.w3c.dom.views.AbstractView;
  
  @Repository public interface AdminRepository extends
  ReactiveCrudRepository<Admin, Long>{
  
  }
 