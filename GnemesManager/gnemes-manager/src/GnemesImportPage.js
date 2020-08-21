import React, {useState} from 'react';
import './GnemesImportPage.css';
import TextField from "@material-ui/core/TextField";
import {makeStyles} from '@material-ui/core/styles';
import Container from "@material-ui/core/Container";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import ImageUploader from 'react-images-upload';
import EditIcon from '@material-ui/icons/Edit';
import BackspaceSharpIcon from '@material-ui/icons/BackspaceSharp';
import Fab from "@material-ui/core/Fab";
import Alert from '@material-ui/lab/Alert';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
            width: '25ch',
        },
    },
    container: {
        background: "linear-gradient(rgba(250,0,0,0.5),transparent)",
        flexGrow: 1,
        overflow: "hidden",

    },
    difficultyTextFiled: {
        width: "100%"
    },
    fab: {
        position: 'absolute',
        top: theme.spacing(2),
        right: theme.spacing(20),
    },
    clearFab: {
        position: 'absolute',
        top: theme.spacing(15),
        right: theme.spacing(20),
    },
    tagTextFiled: {
        width: "100%"
    },
    media: {
        height: 300,
    },
    item: {
        maxWidth: "100%",
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
        // background:"red"
    },
    itemWithLeftPadding:{
        paddingLeft: theme.spacing(2),
    },
    itemInner: {
        maxWidth: "50%",
        // margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
        // background:"yellow"
    },
    sentenceItem: {
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    phraseItem: {
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    infoItem: {
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    tagItem: {
        maxWidth: "0 auto",
        margin: `${theme.spacing(1)}px auto`,
        padding: theme.spacing(2),
    },
    avatarDesign: {
        marginTop: 10
    },
    plusMark: {
        marginTop: 10
    },
    plusMarkLong: {
        marginTop: 10,
        width: "100%"
    }
}));
function GnemesImportPage() {
    let [values, setValues] = useState({response:'',picObj:'',pic:'',difficulty:"1",tags: [''], olSentences: [''], slSentences: [''],phrases:['']});
    const handleDifficultyInputChange = e =>{
        const {value} = e.target
        if(value){
            setValues({...values, difficulty: parseInt(value)})
        }else {
            setValues({...values, difficulty: ""})
        }
    }
    const handleTagInputChange = e => {
        const {name, value} = e.target
        let array = [...values.tags]
        array[name] = value
        setValues({...values, tags: array})
    }
    const handlePhraseInputChange=e=>{
        const {name, value} = e.target
        let array = [...values.phrases]
        array[name] = value
        setValues({...values, phrases: array})
    }
    const handleSentenceInputChange = e => {
        const {name, value, label} = e.target
        console.log("name", name)
        console.log("value", value)
        console.log("target", e.target)
        if (name.startsWith("Ol")) {
            console.log("value", "ol")
            let newArr = [...values.olSentences]
            newArr[name.substr(2)] = value
            setValues({...values, olSentences: newArr})
        } else if (name.startsWith("Sl")) {
            console.log("value", "sl")
            let newArr = [...values.slSentences]
            newArr[name.substr(2)] = value
            setValues({...values, slSentences: newArr})
        }
    }
    const handleLongPlusButtonClick = e => {
        let newOlArr = [...values.olSentences]
        newOlArr.push("")
        let newSlArr = [...values.slSentences]
        newSlArr.push("")
        setValues({...values, olSentences: newOlArr, slSentences: newSlArr})
    }
    const handleTagsPlusButtonClick = e => {
        let array = [...values.tags]
        array.push('')
        setValues({...values, tags: array})
    }
    const handlePhrasePlusButtonClick = e => {
        let array = [...values.phrases]
        array.push('')
        setValues({...values, phrases: array})
    }
    const maxNumber = 69;
    const onChange = (imageList,pictures)=> {
        // data for submit
        // values.pic=imageList[0]
        let objectURL = URL.createObjectURL(imageList[imageList.length-1]);
        console.log(objectURL);
        console.log(pictures);
        setValues({...values,pic:objectURL,picObj:imageList[imageList.length-1]})
    };
    const clearState=()=>{
        setValues({response:'',picObj:'',pic:'',difficulty:"1",tags: [''], olSentences: [''], slSentences: [''],phrases:['']})
    }

    const submitGnemesPost =async()=>{
        let formData = new FormData()
        formData.append("meta",  new Blob([JSON.stringify({
            "difficulty":values.difficulty,
            "oLSentences":values.olSentences,
            "sLSentences":values.slSentences,
            "tag":values.tags,
            "phrase":values.phrases
        })], {
            type: "application/json"
        }))

        await formData.append("file",values.picObj,values.picObj.name)
        console.log("formData",formData.toString())
        console.log("file",values.picObj)
        const requestOptions = {
            method: 'POST',
            headers: {
                'Accept':'application/json',
            },
            body: formData,
        };
        console.log("requestOptions",requestOptions)
        const response=await fetch('http://127.0.0.1:9090/api/v1/gnemes/post/', requestOptions)
        let responseJson = await response.text();
        console.log("response---",responseJson)
        // setValues({picObj:'',pic:'',difficulty:1,tags: [''], olSentences: [''], slSentences: [''],phrases:[''],response:responseJson})
        setValues({...values,response:responseJson})
    }

    const classes = useStyles();
    return (
        <React.Fragment >
            <Container className={classes.container} maxWidth="lg">
                <Paper className={classes.item}>
                    <Grid container
                          direction="row"
                          justify="flex-start"
                          alignItems="stretch">
                        <Grid className={classes.itemInner} direction="column" container wrap="nowrap" spacing={2}>
                            <Grid
                                container
                                direction="row"
                                justify="flex-start"
                                alignItems="stretch">
                                <Grid item>
                                    <Avatar className={classes.avatarDesign}>D</Avatar>
                                </Grid>
                                <Grid className={classes.itemWithLeftPadding} item xs zeroMinWidth>
                                    <TextField className={classes.difficultyTextFiled}
                                               value={values.difficulty}
                                               name={"difficulty"}
                                               label="difficulty"
                                               onChange={handleDifficultyInputChange}
                                               id="outlined-basic" variant="outlined"/>
                                </Grid>
                            </Grid>

                            <Grid>
                                <ImageUploader multiple onChange={onChange} maxNumber={maxNumber}/>
                            </Grid>
                        </Grid>
                        <Grid className={classes.itemInner}>
                            <img
                                className={classes.media}
                                src={values.pic}
                            />
                        </Grid>
                    </Grid>
                </Paper>
                <Paper className={classes.tagItem}>
                    <Grid container wrap="nowrap" spacing={2}>
                        <Grid item>
                            <Avatar className={classes.avatarDesign}>T</Avatar>
                        </Grid>
                        {
                            values.tags.map((value, index) => {
                                return (
                                    <Grid item xs zeroMinWidth>
                                        <TextField
                                            name={index}
                                            value={value}
                                            onChange={handleTagInputChange}
                                            className={classes.tagTextFiled}
                                            label="Tag"
                                            id="outlined-basic" variant="outlined"/>
                                    </Grid>
                                )
                            })
                        }

                        <Grid item xs zeroMinWidth>
                            <Button onClick={handleTagsPlusButtonClick} className={classes.plusMark} variant="contained"
                                    color="secondary">
                                +
                            </Button>
                        </Grid>
                    </Grid>
                </Paper>
                <Paper className={classes.sentenceItem}>
                    {values.olSentences.map((value, index) => {
                        return (
                            <Box>
                                <Grid container wrap="nowrap" spacing={2}>
                                    <Grid item>
                                        <Avatar className={classes.avatarDesign}>S</Avatar>
                                    </Grid>
                                    <Grid item xs zeroMinWidth>
                                        <TextField className={classes.difficultyTextFiled}
                                                   label="OlSentence"
                                                   name={"Ol" + index}
                                                   onChange={handleSentenceInputChange}
                                                   id="outlined-basic" variant="outlined"
                                                   value={value}
                                        />
                                    </Grid>
                                </Grid>
                                <Grid container wrap="nowrap" spacing={2}>
                                    <Grid item>
                                        <Avatar className={classes.avatarDesign}>S</Avatar>
                                    </Grid>
                                    <Grid item xs zeroMinWidth>
                                        <TextField className={classes.difficultyTextFiled}
                                                   label="SlSentence"
                                                   name={"Sl" + index}
                                                   onChange={handleSentenceInputChange}
                                                   id="outlined-basic" variant="outlined"
                                                   value={values.slSentences[index]}
                                        />
                                    </Grid>
                                </Grid>
                            </Box>
                        )
                    })}
                    <Grid item xs zeroMinWidth>
                        <Button onClick={handleLongPlusButtonClick} className={classes.plusMarkLong} variant="contained"
                                color="secondary">
                            +
                        </Button>
                    </Grid>
                </Paper>
                <Paper className={classes.phraseItem}>
                    <Grid container wrap="nowrap" spacing={2}>
                        <Grid item>
                            <Avatar className={classes.avatarDesign}>P</Avatar>
                        </Grid>
                        {
                            values.phrases.map((value, index) => {
                                return (
                                    <Grid item xs zeroMinWidth>
                                        <TextField
                                            name={index}
                                            value={value}
                                            onChange={handlePhraseInputChange}
                                            className={classes.tagTextFiled}
                                            label="Phrase"
                                            id="outlined-basic" variant="outlined"/>
                                    </Grid>
                                )
                            })
                        }

                        <Grid item xs zeroMinWidth>
                            <Button onClick={handlePhrasePlusButtonClick} className={classes.plusMark} variant="contained"
                                    color="secondary">
                                +
                            </Button>
                        </Grid>
                    </Grid>
                </Paper>
                <Paper className={classes.infoItem}>
                    <Alert severity="info">{values.response}</Alert>
                </Paper>
                <Fab onClick={submitGnemesPost} aria-label={"add"} className={classes.fab} color={"secondary"}>
                    <EditIcon />
                </Fab>
                <Fab onClick={clearState} aria-label={"add"} className={classes.clearFab} color={"first"}>
                    <BackspaceSharpIcon />
                </Fab>
            </Container>
        </React.Fragment>
    )

}

export default GnemesImportPage