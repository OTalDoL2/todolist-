<template>
    <div> 
        <div class="task" v-for="item, index in notes" :key="index" >
            <div >
                <h1 class="titulo">
                    {{item.titulo}}
                </h1>
            </div>
            <div class="nota">
              {{item.nota}}
            </div>
            <button @click="delNotes(item.id)">
                <v-icon size="30" color="#eae9e1"> mdi-trash-can-outline  </v-icon>
            </button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Task',
    data() {
        return{
            notes: {}
        }
    },
    methods: {
        getNotes(){
            console.log('pegou haha')
        fetch("http://localhost:8080/notes", {
            headers:{
            'Accept':  'application/json',
            'Content-Type': 'application/json'
            },
            method: "GET",
        })
        .then(response => response.json())
        .then(cad => {
            this.notes = cad
        })
        },
        postNotes(){
        fetch("http://localhost:8080/notes/nota", {
            headers: {
            'Accept': 'application/json',
            'Content-Type' : 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
            titulo: titulo.value,
            nota: texto.value,
            // prioridade: prioridade.value,
            })
        })
        .then(response => response.text())
        .then(cad => {
            this.getNotes();
        })
        },
        delNotes(id){
        fetch("http://localhost:8080/notes/"+id, {
                headers: {
                'mode': 'cors',
                'Accept': 'application/json',
                'Content-Type' : 'application/json'
                },
                method: "DELETE",
            })
            .then(function (text) {
                console.log("Delete sucess", text)
            })
            .then(function (error) {
                console.log("Delete failed", error)
            })
            setTimeout(() => { 
                this.getNotes() 
            }, 100);
        }
    },
    beforeMount() {
        this.getNotes();
    },
    mounted(){
    const thisInstance = this
    this.$root.$on('getNotesEvent', function(){
      thisInstance.getNotes()
    })
  }
}
</script>

<style scoped>
.task{
  display: flex;
  flex-direction: column;
  /* padding: 5%; */
  /* padding: top left right bottom; */
  padding: 0 5% 0 5%;
  width: 90%;
  height: 150px;
  border-radius: 25px;
  background-color: aliceblue;
  margin-bottom: 25px;
}
.titulo{
    font-size: 26px;
}
</style>