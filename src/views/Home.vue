<template>
  <div class="home">  
    <div class="board" >
      <Task />
    </div>
    <Formulario v-if="popupTriggers.buttonTrigger" :TogglePopup="() => TogglePopup('buttonTrigger')" />

    <button @click="() => TogglePopup('buttonTrigger')" >Popup</button>
    <!-- <button @click="a = !a" >Popup</button> -->
    <button @click="getNotes">refresh</button>
    
    
  </div>
</template>

<script>
import {ref} from 'vue'
import Formulario from '../components/Forms.vue'
import Task from '@/components/Task.vue'

export default {
  name: 'Home',
  setup(){
    const popupTriggers = ref({
      buttonTrigger: false
    })

    const TogglePopup = (trigger) => {
      popupTriggers.value[trigger] = !popupTriggers.value[trigger]
    }

    return { Popup, popupTriggers, TogglePopup }
  },
  data() {
    return{
      notes: {},
      a: false
    }
  },
  methods: {
    getNotes(){
      this.$root.$emit('getNotesEvent')
    }
  },
  beforeMount() {
    this.getNotes();
  },
  components: {
    Formulario,
    Task,
    
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
  /* height: 500px;
  width: 500px; */
  width: 90%;
  height: 600px;
  overflow: scroll;

}

</style>