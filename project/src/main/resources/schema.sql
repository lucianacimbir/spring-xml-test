CREATE TABLE `student` (
  `id` bigint NOT NULL,
  `name` varchar(45),
  `class_id` varchar(10),
  `year` int
);

CREATE TABLE `exam` (
  `id` bigint NOT NULL,
  `class_id` varchar(10) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `professor` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL
);

CREATE TABLE `grade` (
  `exam_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `grade` int DEFAULT NULL
);
