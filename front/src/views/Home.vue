<template>
  <div class="home">
    <h2>Titulo: </h2>
    <input type="text" id="titulo">
    <h2>Nota: </h2>
    <input type="text" id="texto">
    <h2>Prioridade: </h2>
    <select name="" id="prioridade">
      <option value="alta">2</option>
      <option value="media">1</option>
      <option value="baixa">0</option>
    </select>
    <div v-for="item in notes" >
      {{item.titulo}}
      {{item.nota}}
      {{item.prioridade}}
      <button @click="delNotes(item.id)">Adm, alguem excloi ele?</button>
    </div>
    <button @click="postNotes">aaaaaa</button>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

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
        console.log('hahaha, se liga no beat')
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
      this.getNotes()
    }
  },
  beforeMount() {
    this.getNotes();
  },
  components: {
    HelloWorld
  },
}
</script>
