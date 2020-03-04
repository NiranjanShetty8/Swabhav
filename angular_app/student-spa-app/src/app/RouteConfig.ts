import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';

export const routeArray: Routes = [
    {
        path: '',
        component: HomeComponent
    }, {
        path: 'home',
        component: HomeComponent
    }, {
        path: 'add',
        component: AddComponent
    }, {
        path: 'edit/:id',
        component: EditComponent
    }, {
        path: '**',
        component: HomeComponent
    }];