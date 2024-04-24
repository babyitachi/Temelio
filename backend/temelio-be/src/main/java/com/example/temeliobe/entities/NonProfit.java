package com.example.temeliobe.entities;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class NonProfit {
    private String email;
    private String name;
    private String address;
    private Set<Email> emailsRecieved;
}

// nonprofit
// cols: emailid, name, address

//  email: guid:eid, sender_emaild, rec_emailid, rec_address, rec_name, template_id
//          (s1@, s2@, s2 street, s2)

// template: id, body, isDraft

// draft: rec_list:[], templete_id


// email: guid:eid, sender_eid, rec_eid, text_body, rid 
// replies: guid:rid, sender_eid, rec_eid, text_body, eid


// convos: guid:id, sender_eid, rec_eid, text_body 