CREATE TABLE public.renovation (
   id serial4 NOT NULL,
   "name" varchar(255) NOT NULL,
   dimensions varchar(255) NOT NULL,
   active bool NOT NULL,
   creation_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   last_edit_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   volume varchar(255) NULL,
   field varchar(255) NULL,
   CONSTRAINT renovation_pkey PRIMARY KEY (id)
);