import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TaskListPageRoutingModule } from './task-list-routing.module';

import { RouterModule } from '@angular/router';
import { TaskListPage } from './task-list.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TaskListPageRoutingModule,
    TaskListPage,
    RouterModule.forChild([{ path: '', component: TaskListPage }])
  ],
  declarations: [TaskListPage]
})
export class TaskListPageModule {}
