create table category (
    id IDENTITY,
    name varchar(50),
    description varchar(255),
    image_url varchar(50),
    is_active boolean,
     
    CONSTRAINT pk_category_id PRIMARY KEY(id) 
);

INSERT into category (name, description, image_url, is_active) 
values('Mobile', 'this is the description for Mobile', 'CAT_3.png',true);