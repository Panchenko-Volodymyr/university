DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS schedules;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS classrooms;
DROP TABLE IF EXISTS days;
DROP TABLE IF EXISTS groups;

CREATE TABLE IF NOT EXISTS subjects
(
    id  BIGSERIAL PRIMARY KEY,
    names_of_subjects VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS classrooms
(
    id  BIGSERIAL PRIMARY KEY,
    name_of_classrooms VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS days
(
    id  BIGSERIAL PRIMARY KEY,
    names_of_week VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS groups
(
    id  BIGSERIAL PRIMARY KEY,
    group_names VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS students
(
    id  BIGSERIAL PRIMARY KEY,
    first_names VARCHAR(255) NOT NULL,
    last_names  VARCHAR(255) NOT NULL,
    group_id    bigint
        constraint fkmsev1nou0j86spuk5jrv19mss
            references groups
);

CREATE TABLE IF NOT EXISTS schedules
(
    id  BIGSERIAL PRIMARY KEY,
    classroom_id bigint
        constraint fketjivfiadf6tro4vbyxhn52cg
            references classrooms,
    day_id       bigint
        constraint fkliu6miym9klmxjubwf109fj26
            references days,
    group_id     bigint
        constraint fki8nxapnjxk1chfkho5f4h33aa
            references groups,
    subjects_id  bigint
        constraint fkermv5jb2nma6pn83u55s2klaq
            references subjects
);