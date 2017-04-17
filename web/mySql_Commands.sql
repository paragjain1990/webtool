create table webapp
(
url               TEXT,
encoding          TEXT,
title             LONGTEXT,
keywords          TEXT,
description       LONGTEXT,
content		      LONGTEXT,
num_links         int(5),
num_images        int(5),
num_stopWords     int(5),
num_contentLength int(5)
);

desc webapp;

select * from webapp;
