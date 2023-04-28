import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostsView from "@/views/PostsView.vue";
import WriteView from "@/views/WriteView.vue";
import ReadView from "@/views/ReadView.vue";
import EditView from "@/views/EditView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },

    {
      path:'/write',
      name:'write',
      component: WriteView
    },
    {
      path:'/posts',
      name:'posts',
      component: PostsView
    },
    {
      path:'/read/:postId',
      name: 'read',
      component: ReadView,
      props:true
    },
    {
      path:'/edit/:postId',
      name: 'edit',
      component: EditView,
      props:true
    }
  ]
})

export default router
