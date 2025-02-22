
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { Task } from '../../models/task';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.page.html',
  styleUrls: ['./task-form.page.scss'],
})
export class TaskFormPage {
  task: Task = { id: '', title: '', description: '', status: 'pending', dueDate: '', projectId: '' };
  projectId: string = '';

  constructor(private apiService: ApiService, private route: ActivatedRoute, private router: Router) {
    this.projectId = this.route.snapshot.paramMap.get('id')!;
  }

  saveTask() {
    this.task.projectId = this.projectId;
    this.apiService.createTask(this.projectId, this.task).subscribe(() => {
      this.router.navigate(['/task-list', this.projectId]);
    });
  }
}
