import React, {useState} from 'react';
import './GnemesImportPage.css';
import Box from "@material-ui/core/Box";
import TextField from "@material-ui/core/TextField";
import {makeStyles} from '@material-ui/core/styles';
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
            width: '25ch',
        },
    },
    container: {
        background: "linear-gradient(rgba(250,0,0,0.5),transparent)",
        backgroundColor: "orange", /*this your primary color*/
        flexGrow: 1,
        padding: theme.spacing(0, 3),
        overflow: "hidden",

    },
    difficultyTextFiled: {
        width:"100%"
    },
    tagTextFiled: {
        width:"100%"
    },
    item: {
        maxWidth: 400,
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    tagItem:{
        maxWidth: "0 auto",
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    avatarDesign:{
        marginTop:10
    }
}));

function GnemesImportPage() {
    let [] = useState();

    const classes = useStyles();
    return (
        <React.Fragment>
            <Container className={classes.container} maxWidth="lg">
                <Paper className={classes.item}>
                    <Grid container wrap="nowrap" spacing={2}>
                        <Grid item>
                            <Avatar className={classes.avatarDesign}>D</Avatar>
                        </Grid>
                        <Grid item xs zeroMinWidth>
                            <TextField className={classes.difficultyTextFiled}
                                       label="Difficulty"
                                       id="outlined-basic" variant="outlined"/>
                        </Grid>
                    </Grid>
                </Paper>
                <Paper className={classes.tagItem}>
                    <Grid container wrap="nowrap" spacing={2}>
                        <Grid item>
                            <Avatar className={classes.avatarDesign}>T</Avatar>
                        </Grid>
                        <Grid item xs zeroMinWidth>
                            <TextField className={classes.tagTextFiled}
                                       label="Tag"
                                       id="outlined-basic" variant="outlined"/>
                        </Grid>
                        <Grid item xs zeroMinWidth>
                            <TextField className={classes.tagTextFiled}
                                       label="Tag"
                                       id="outlined-basic" variant="outlined"/>
                        </Grid>
                        <Grid item xs zeroMinWidth>
                            <TextField className={classes.tagTextFiled}
                                       label="Tag"
                                       id="outlined-basic" variant="outlined"/>
                        </Grid>
                        <Grid item xs zeroMinWidth>
                            <Button variant="contained" color="secondary">
                                +
                            </Button>
                        </Grid>

                    </Grid>
                </Paper>
            </Container>
        </React.Fragment>


        // <Box className={classes.container}>
        //         <TextField className={classes.textFiled}
        //             label="Difficulty"
        //             id="outlined-basic"  variant="outlined" />
        //         <Box>
        //             <Typography variant="h1" component="h2">
        //                 h1. Heading
        //             </Typography>
        //             <TextField className={classes.textFiled}
        //                        label="Difficulty"
        //                        id="outlined-basic"  variant="outlined" />
        //         </Box>
        //
        // </Box>
    )

}

export default GnemesImportPage