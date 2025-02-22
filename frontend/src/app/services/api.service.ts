import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project';
import { Task } from '../models/task';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:9090'; // Change avec l'URL de ton backend

  constructor(private http: HttpClient) {}

  // Gestion des projets
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${this.apiUrl}/project`);
  }

  createProject(project: Project): Observable<Project> {
    return this.http.post<Project>(`${this.apiUrl}/project`, project);
  }

  // Gestion des tâches
  getTasksByProject(projectId: string): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/project/${projectId}/tasks`);
  }

  createTask(projectId: string, task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.apiUrl}/project/${projectId}/tasks`, task);
  }
}
