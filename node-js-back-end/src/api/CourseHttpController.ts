import express from 'express';
import {datasource} from "../db/dbcp";

export const router = express.Router();

type Course = {
    id: string,
    description: string,
    duration: string
}

router.get('/', async (req, res) => {
    const result = await datasource.query('SELECT * FROM course');
    res.json(result);
});

router.post('/', async (req, res) => {
    const course = req.body as Course;
    if (!course.id.trim() || !course.description.trim() || !course.duration.trim()){
        res.status(400).send("Invalid data. id, description and duration cannot be empty");
    }
    else {
        try{
            const result = await datasource.query("INSERT INTO course (id, description, duration) VALUES (?,?,?)",[course.id, course.description, course.duration]);
            res.status(201).json(course);
        }
        catch (err:any){
            if (err.sqlState === '23000'){
                res.status(409).send("Failed to save. Id already exists");
            }
            else {
                throw err;
            }
        }
    }
});

router.delete('/:courseId', async (req, res) => {
    const result = await datasource.query('DELETE FROM course WHERE id=?',[req.params.courseId]);
    if (result.affectedRows === 1){
        res.sendStatus(204);
    }
    else{
        res.status(404).send("Course id not found");
    }
});