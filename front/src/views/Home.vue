<template>
  <div class="home">  
      <Formulario />
    
      <div class="board">
        <div class="task" v-for="item, index in notes" :key="index" >
          <div class="titulo">
            {{item.titulo}}
          </div>
          <div class="nota">
            {{item.nota}}
          </div>
          <div class="prioridade">
            {{item.prioridade}}
          </div>
          <button @click="delNotes(item.id)">Adm, alguem excloi ele?</button>
        </div>
        <button @click="postNotes">aaaaaa</button>
      </div>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'
import Formulario from '../components/Forms.vue'

export default {
  name: 'Home',
  data() {
    return{
      notes: {}
    }
  },
  methods: {
    getNotes(){
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
          prioridade: prioridade.value,
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
  components: {
    HelloWorld,
    Formulario
  },
}
</script>

<style scoped>
.home{
  overflow: hidden;
  background-color: brown;
  height: 98vh;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.board{
  background-color: blue;
  height: 500px;
  width: 500px;

}
.task{
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 150px;
  border-radius: 15px;
  background-color: aliceblue;
}
</style>