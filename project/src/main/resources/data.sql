INSERT INTO `student` (`id`, `name`, `class_id`, `year`) VALUES (1, 'Alexandrescu Alin',      '101', 1);
INSERT INTO `student` (`id`, `name`, `class_id`, `year`) VALUES (2, 'Barbulescu Beatrice',    '101', 1);
INSERT INTO `student` (`id`, `name`, `class_id`, `year`) VALUES (3, 'Constantinescu Claudiu', '101', 1);
INSERT INTO `student` (`id`, `name`, `class_id`, `year`) VALUES (4, 'Diaconescu Daniela',     '404', 4);

INSERT INTO `exam` (`id`, `class_id`, `subject`, `professor`, `date`, `room`) VALUES (12, '101', 'Analiza matematica', 'Cenusa Gh', '2022-06-15', '2001');

INSERT INTO `grade` (`exam_id`, `student_id`, `grade`) VALUES (12, 1, 8);
INSERT INTO `grade` (`exam_id`, `student_id`, `grade`) VALUES (12, 2, 9);
INSERT INTO `grade` (`exam_id`, `student_id`, `grade`) VALUES (12, 3, 6);
