import React, {useEffect, useState} from "react";
import axios from "axios";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const Books = () => {
    const [books, setBooks] = useState([]);
    const fetchtBooks = () => {
        axios.get("http://localhost:8080/books")
            .then(res => {
                setBooks(res.data);
            });
    };


    useEffect(() => {
        fetchtBooks()
    }, []);

    return books.map((books, index) => {
        return (

            <TableContainer component={Paper}>
                <Table sx={{minWidth: 650}} aria-label="simple table" key={books.id}>
                    <TableBody key={books.id}>
                        <TableRow
                            key={books.id}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {books.name}
                            </TableCell>
                            <TableCell align="right"></TableCell>
                            <TableCell align="right">{books.id}</TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>

        )
    });
};


export default Books;